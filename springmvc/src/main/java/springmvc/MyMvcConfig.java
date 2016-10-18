package springmvc;

import interceptor.DemoInterceptor;
import messageconverter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * Created by moon on 16/10/2016.
 *
 * @Description:
 */
@Configuration
@EnableWebMvc
@ComponentScan({"springmvc", "advice"})
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/classes/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setViewClass(JstlView.class);
        return internalResourceViewResolver;
    }

    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }


    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }

    @Bean
    public MyMessageConverter converter() {
        return new MyMessageConverter();
    }

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    /**
     * 不需要拦截
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }


    /**
     * 拦截处理 request 和 response 数据
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index2").setViewName("/index");
        registry.addViewController("/").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/conventer");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }
}
