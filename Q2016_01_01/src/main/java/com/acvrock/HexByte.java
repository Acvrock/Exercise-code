package com.acvrock;

/**
 * Created by moon on 10/12/2016.
 *
 * @Description:
 */
public class HexByte {
    static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    static byte b = (byte) 0xf1; // 11110001

    public static void main(String[] args) {
        System.out.println(b);
        System.out.printf("%h\n", b);
        System.out.println("b=0x" + hex[(b >> 4) & 0x0f] + hex[b & 0x0f]);
    }

    public static int getUnsignedByte(byte data) {
        return data & 0xFF;
    }

    public static int getUnsignedByte(short data) {
        return data & 0xFFFF;
    }

    public static long getUnsignedInt(int data) {
        return data & 0xFFFFFFFF;
    }
}
