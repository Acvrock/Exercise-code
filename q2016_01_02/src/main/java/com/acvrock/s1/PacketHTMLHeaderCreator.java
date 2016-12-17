package com.acvrock.s1;

/**
 * Created by moon on 17/12/2016.
 *
 * @Description:
 */
public class PacketHTMLHeaderCreator extends PacketDecorator {

    public PacketHTMLHeaderCreator() {
    }

    public PacketHTMLHeaderCreator(IPacketCreator creator) {
        super(creator);
    }

    @Override
    public String handleContent(String in) {
        if(null==component) return in;
        return component.handleContent(in)+"，PacketHTMLHeaderCreator装饰过了";
    }
}
