package com.acvrock.s1;

/**
 * Created by moon on 17/12/2016.
 *
 * @Description:
 */
public abstract class Decorator implements ICreator {
    ICreator component;

    public Decorator() {
    }

    public Decorator(ICreator creator) {
        component = creator;
    }

    public void setComponent(ICreator component) {
        if (this == component) throw new RuntimeException("不能循环装饰");
        this.component = component;
    }


}
