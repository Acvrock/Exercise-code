package com.acvrock.s1;

/**
 * Created by moon on 17/12/2016.
 *
 * @Description:
 */
public abstract class PacketDecorator implements IPacketCreator {
    IPacketCreator component;

    public PacketDecorator() {
    }

    public PacketDecorator(IPacketCreator creator) {
        component = creator;
    }

    public void setComponent(IPacketCreator component) {
        if (this == component) throw new RuntimeException("不能循环装饰");
        this.component = component;
    }


}
