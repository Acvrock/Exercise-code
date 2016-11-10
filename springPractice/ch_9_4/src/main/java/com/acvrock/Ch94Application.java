package com.acvrock;

import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.dsl.file.Files;
import org.springframework.integration.dsl.mail.Mail;
import org.springframework.integration.feed.inbound.FeedEntryMessageSource;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.scheduling.PollerMetadata;

import java.io.File;
import java.io.IOException;

import static org.springframework.core.SpringProperties.getProperty;

@SpringBootApplication
public class Ch94Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch94Application.class, args);
    }

    @Value("https://spring.io/blog.atom")
    Resource resource;

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedDelay(500).get();
    }

    @Bean
    public FeedEntryMessageSource feedEntryMessageSource() throws IOException {
        FeedEntryMessageSource feedEntryMessageSource = new FeedEntryMessageSource(resource.getURL(), "news");
        return feedEntryMessageSource;
    }

    @Bean
    public IntegrationFlow myFlow() throws IOException {
        return IntegrationFlows.from(feedEntryMessageSource()).<SyndEntry, String>route(
                payload ->
                        payload.getCategories().get(0).getName(),
                mapping ->
                        mapping.channelMapping("releases", "releasesChannel").
                                channelMapping("engineering", "engineeringChannel").
                                channelMapping("news", "newsChannel")
        ).get();
    }

    @Bean
    public IntegrationFlow releassesFlow() {
        return IntegrationFlows.from(MessageChannels.queue("releasesChannel", 10))
                .<SyndEntry, String>transform(payload -> "《" + payload.getTitle() + "》" + payload.getLink() + getProperty("line.separator"))
                .handle(Files.outboundAdapter(new File("/Users/moon/springblog"))
                        .fileExistsMode(FileExistsMode.APPEND)
                        .charset("UTF-8")
                        .fileNameGenerator(message -> "releases.txt").get()
                ).get();
    }

    @Bean
    public IntegrationFlow engineeringFlow() {
        return IntegrationFlows.from(MessageChannels.queue("engineeringChannel", 10))
                .<SyndEntry, String>transform(e -> "《" + e.getTitle() + "》" + e.getLink() + getProperty("line.separator"))
                .handle(Files.outboundAdapter(new File("/Users/moon/springblog"))
                        .fileExistsMode(FileExistsMode.APPEND)
                        .charset("UTF-8")
                        .fileNameGenerator(message -> "engineering.txt").get()
                ).get();
    }

    @Bean
    public IntegrationFlow newsFlow() {
        return IntegrationFlows.from(MessageChannels.queue("newsChannel", 10))
                .<SyndEntry, String>transform(e -> "《" + e.getTitle() + "》" + e.getLink() + getProperty("line.separator"))
                .enrichHeaders(
                        Mail.headers().subject("来自 Spring 的新闻")
                                .to("acvrock.cn@gmail.com")
                                .from("acvrock.cn@gmail.com"))
                .handle(
                        Mail.outboundAdapter("smtp.gmail.com")
                                .port(587)
                                .protocol("smtp")
                                .credentials("acvrock.cn@gmail.com", "****")
                                .javaMailProperties(
                                        p -> {
                                            p.put("mail.debug", "false");
                                            p.put("mail.smtp.starttls.enable", "true");
                                        }),
                        e -> e.id("smtpOut")
                ).get();
    }

}
