package com.acvrock.eventbus;

import java.util.concurrent.Executors;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

/**
 * Created by panjinghong
 * 总线工厂,所有的监听者都会在这里注册
 */
public class GuavaEventBusFactory {

    private static final GuavaEventBusFactory factory = new GuavaEventBusFactory();

    private final EventBus eventBus;

    private GuavaEventBusFactory() {
        eventBus = new AsyncEventBus("AsyncGuavaEventBus", Executors.newFixedThreadPool(5));
    }

    public static final GuavaEventBusFactory getDefault() {
        return factory;
    }

    public EventBus eventBus() {
        return eventBus;
    }

}