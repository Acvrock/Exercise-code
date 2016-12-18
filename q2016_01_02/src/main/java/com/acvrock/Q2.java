package com.acvrock;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by moon on 03/12/2016.
 *
 * @Description: Q 2 分别用大头和小头模式将整数 a=10240写入到文件中（4个字节），并且再正确读出来，打印到屏幕上，同时截图UltraEdit里的二进制字节序列，做对比说明
 */
public class Q2 {
    public static void main(String[] args) throws IOException {
        int a = 10240;
        byte[] bigEndianArray = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(a).array();
        byte[] litileEndianArray = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(a).array();
        System.out.println("BIG_ENDIAN："+Arrays.toString(bigEndianArray));
        System.out.println("LITTLE_ENDIAN："+Arrays.toString(litileEndianArray));
        write("BIG_ENDIAN", bigEndianArray);
        write("LITTLE_ENDIAN", litileEndianArray);
        show("BIG_ENDIAN",ByteOrder.BIG_ENDIAN);
        show("LITTLE_ENDIAN",ByteOrder.LITTLE_ENDIAN);
    }

    /**
     * 一行代码写文件的封装.
     *
     * @param paths
     * @param content
     * @throws IOException
     */
    private static void write(String paths, Iterable<? extends CharSequence> content) throws IOException {
        Files.write(Paths.get(paths), content);
    }
    /**
     * 一行代码写文件的封装
     *
     * @param paths
     * @param content
     * @throws IOException
     */
    private static void write(String paths, byte[] content) throws IOException {
        Files.write(Paths.get(paths), content);
    }
    /**
     * 一行代码输出文件
     * <p>
     * java 8 一行代码读取文件内容
     * <p>
     * 1）文件可能很大，可能会超出内存空间，使用前要做评估。
     * 2）要输出日志，记录为什么无法读取文件或者在阅读文件时遇到的任何错误。
     * 3）在把字节转换成字符时，应该指定字符编码。
     * 4）要处理文件不存在的情况。
     * 还要注意，如果读入的文件的编码是ANSI编码，那么上面的例子在读取文件内容时会报java.nio.charset.MalformedInputException: Input length = 1错误。
     *
     * @param filepath
     *  @param byteOrder
     * @throws IOException
     */
    private static void show(String filepath,ByteOrder byteOrder) throws IOException {
        Files.readAllLines(Paths.get(filepath), Charset.defaultCharset()).forEach(t -> {

            int x = java.nio.ByteBuffer.wrap(t.getBytes()).order(byteOrder).getInt();

            System.out.println(filepath + "------>#" +x);
        });
    }
}
