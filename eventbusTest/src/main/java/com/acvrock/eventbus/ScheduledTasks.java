package com.acvrock.eventbus;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by panjinghong on 2018/8/6.
 */
@Component
public class ScheduledTasks {
	Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	@Scheduled(fixedRate = 2000)
	public void scheduleTaskWithFixedRate() {
		logger.info("send msg - {}",new Date());
		CallBack callBack = new CallBack(1,System.currentTimeMillis());
		GuavaEventBusFactory.getDefault().eventBus().post(callBack);
	}
}
