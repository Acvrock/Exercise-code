package com.acvrock.s1;

/**
 * Created by moon on 17/12/2016.
 *
 * @Description:
 */
public class PacketBodyCreator implements IPacketCreator {
    @Override
    public String handleContent(String in) {
        return in; //返回核心数据，没有装饰
    }
}
