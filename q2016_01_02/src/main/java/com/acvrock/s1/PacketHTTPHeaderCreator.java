package com.acvrock.s1;

/**
 * Created by moon on 17/12/2016.
 *
 * @Description:
 */
public class PacketHTTPHeaderCreator extends PacketDecorator {

    public PacketHTTPHeaderCreator() {
    }

    public PacketHTTPHeaderCreator(IPacketCreator creator) {
        super(creator);
    }

    @Override
    public String handleContent(String in) {
        if(null==component) return in;
        return component.handleContent(in)+"，PacketHTTPHeaderCreator装饰过了";
    }
}
