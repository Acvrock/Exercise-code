package com.acvrock.eventbus;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by panjinghong on 2018/8/6.
 */
public abstract class AbstractListener<T> implements InitializingBean {
	@Override
	public void afterPropertiesSet() {
		GuavaEventBusFactory.getDefault().eventBus().register(this);
	}

	protected abstract void onEvent(T t) throws Exception;
}
