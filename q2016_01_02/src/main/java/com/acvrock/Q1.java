package com.acvrock;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by moon on 03/12/2016.
 *
 * @Description: Q:1  得到 String s="中国" 这个字符串的utf-8编码，gbk编码，iso-8859-1编码的字符串，看看各自有多少字节，同时解释为什么以utf-8编码得到的byte[]无法用gbk的方式“还原”为原来的字符串
 * A:
 */
public class Q1 {

    /**
     * 8 位 UCS 转换格式
     */
    public static final String UTF_8 = "UTF-8";
    /**
     * 中文超大字符集
     */
    public static final String GBK = "GBK";
    /**
     * ISO 拉丁字母表 No.1，也叫作 ISO-LATIN-1
     */
    public static final String ISO_8859_1 = "ISO-8859-1";

    /**
     * @param str
     * @param charSet
     * @return
     * @throws UnsupportedEncodingException
     */
    public static int getStringByteLength(String str, String charSet) throws UnsupportedEncodingException {
        return str.getBytes(charSet).length;
    }

    /**
     * @param str
     * @param oldCharSet
     * @param newCharSet
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String changeCharSet(String str, String oldCharSet, String newCharSet) throws UnsupportedEncodingException {
        System.out.println("默认编码 bytes " + Arrays.toString(str.getBytes()));
        byte[] bytes = str.getBytes(oldCharSet);
        System.out.println(oldCharSet + "编码 bytes " + Arrays.toString(bytes));
        String s = new String(bytes, newCharSet);
        System.out.println(newCharSet + "编码 bytes " + Arrays.toString(s.getBytes(newCharSet)));
        return s;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String china = "中国";  // 默认随系统，这里是 UTF-8
        String chinaUTF8 = changeCharSet(china, UTF_8, UTF_8);
        System.out.println("UTF-8 编码字符串:" + chinaUTF8);
        int chinaUTF8Length = getStringByteLength(chinaUTF8, UTF_8);
        System.out.println("字节数组长度" + chinaUTF8Length);
        System.out.println();
        String chinaGBK = changeCharSet(china, GBK, GBK);
        System.out.println("GBK 编码字符串:" + chinaGBK);
        int chinaGBKLength = getStringByteLength(chinaGBK, GBK);
        System.out.println("字节数组长度" + chinaGBKLength);
        System.out.println();
        String chinaISO = changeCharSet(china, ISO_8859_1, ISO_8859_1);
        System.out.println("ISO_8859_1 编码字符串:" + chinaISO);
        int chinaISOLength = getStringByteLength(chinaISO, ISO_8859_1);
        System.out.println("字节数组长度" + chinaISOLength);
        System.out.println();
        String chinaGBK1 = changeCharSet(china, UTF_8, GBK);
        System.out.println("UTF-8 转 GBK 编码字符串:" + chinaGBK1);
        int chinaGBK1Length = getStringByteLength(chinaGBK1, GBK);
        System.out.println("字节数组长度" + chinaGBK1Length);
    }
}
