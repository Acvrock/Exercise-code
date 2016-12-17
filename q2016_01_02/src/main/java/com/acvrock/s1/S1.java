package com.acvrock.s1;

/**
 * Created by moon on 17/12/2016.
 *
 * @Description:
 */
public class S1 {
    public static void main(String[] args) {
        PacketHTMLHeaderCreator packetHTMLHeaderCreator = new PacketHTMLHeaderCreator();
        PacketBodyCreator packetBodyCreator = new PacketBodyCreator();
        PacketHTTPHeaderCreator packetHTTPHeaderCreator = new PacketHTTPHeaderCreator();

        packetHTMLHeaderCreator.setComponent(packetHTTPHeaderCreator);

        System.out.println(packetHTMLHeaderCreator.handleContent("sdfsa"));
    }


}
