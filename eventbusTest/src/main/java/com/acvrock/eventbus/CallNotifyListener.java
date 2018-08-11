package com.acvrock.eventbus;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by panjinghong on 2018/8/6.
 */
@Component
@Lazy(false)
public class CallNotifyListener extends AbstractListener<CallBack> {
	Logger logger = LoggerFactory.getLogger(CallNotifyListener.class);

	@Subscribe
	@Override
	public void onEvent(CallBack event) throws Exception {
		logger.info("CallNotifyListener onEvent :{},{}", event.getAppid(),event);
	}
}
