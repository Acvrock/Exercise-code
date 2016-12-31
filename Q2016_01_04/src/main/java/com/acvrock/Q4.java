package com.acvrock;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by moon on 29/12/2016.
 *
 * @Description:
 */
public class Q4 {
    static final int W = 10000;
    static final int BASESALARYMAX = 100 * W;
    static final int BASESALARYMIN = 5 * W;
    static final int BASESALARYRYBOUND = BASESALARYMAX - BASESALARYMIN + 1;
    static final int BOUNDMAX = 10 * W;
    static final int BOUNDBOUND = BOUNDMAX + 1;
    static final byte[] str = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z', 'A', 'B',
            'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9'};

    private static final byte DELIMITER = (byte) '\n';


    public static void main(String[] args) throws IOException {
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 1000; i++) {
//            stream();
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间

        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            parallelStream();
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime1 - startTime1) + "ms");    //输出程序运行时间
    }

//    private static void stream() throws IOException {
//        Salary[] salaries = new Salary[10000];
//        Random random = new Random();
////        生成数组
//        byte[] bytes = Arrays.stream(salaries).map(salary -> {
//                    salary = new Salary();
//                    salary.setBaseSalary(random.nextInt(BASESALARYRYBOUND) + BASESALARYMIN);
//                    salary.setBonus(random.nextInt(BOUNDBOUND));
//                    StringBuffer buf = new StringBuffer();
//                    for (int i = 0; i < 5; i++) {
//                        int num = random.nextInt(62);
//                        buf.append(str.charAt(num));
//                    }
//                    salary.setName(buf.toString());
//                    return salary;
//                }
//        ).reduce(new StringBuilder(), (s1, s2) -> s1.append(s2).append('\n'), StringBuilder::append).toString().getBytes();
//
////        存进文件
//        write("salaries", bytes);
//
////        取出文件内的数据并分组
//        Map<String, List<Integer>> salarieMap = Files.readAllLines(Paths.get("salaries"), Charset.defaultCharset())
//                .stream().filter(ss -> Integer.parseInt(ss.substring(6, ss.lastIndexOf(","))) > 10 * W)
//                .collect(
//                        groupingBy(s -> s.substring(0, 2), mapping(s1 -> Integer.parseInt(s1.substring(6, s1.lastIndexOf(","))), toList())));
////        排序
//        Object[] objects = salarieMap
//                .entrySet()
//                .stream()
//                .sorted(
//                        (f1, f2) ->
//                                Long.compare(f2.getValue().stream().mapToInt(Integer::intValue).sum()
//                                        , f1.getValue().stream().mapToInt(Integer::intValue).sum()))
//                .limit(10).map(
//                        keys -> new String(keys.getKey() + "," + keys.getValue().stream().mapToInt(Integer::intValue).sum() + "," + keys.getValue().stream().count()))
//                .toArray();
//
////        System.out.println(Arrays.toString(objects));
//    }


    private static void parallelStream() throws IOException {
        byte[][] salaries = new byte[10000][];
        Random random = new Random();
//        生成数组
        byte[] bytes = Arrays.stream(salaries).map(salary -> {
                    salary = new byte[14]; //5+4+4
                    int baseSalary = random.nextInt(BASESALARYRYBOUND) + BASESALARYMIN;
                    byte[] baseSalarybytes = ByteBuffer.allocate(4).putInt(baseSalary).array();
                    System.arraycopy(baseSalarybytes, 0, salary, 5, 4);
                    int bonus = random.nextInt(BOUNDBOUND);
                    byte[] bonusbytes = ByteBuffer.allocate(4).putInt(bonus).array();
                    System.arraycopy(bonusbytes, 0, salary, 9, 4);
                    for (int i = 0; i < 5; i++) {
                        salary[i] = str[random.nextInt(62)];
                    }
                    salary[13] = DELIMITER;
                    return salary;
                }
        ).reduce(new byte[140004], (b1, b2) -> {
            int index = convertirOctetEnEntier(b1[140000], b1[140001], b1[140002], b1[140003]);
            System.arraycopy(b2, 0, b1, index, b2.length);
            index = index + b2.length;
            byte[] indexbytes = ByteBuffer.allocate(4).putInt(index).array();
            b1[140000] = indexbytes[0];
            b1[140001] = indexbytes[1];
            b1[140002] = indexbytes[2];
            b1[140003] = indexbytes[3];
            return b1;
        });

//        存进文件
        write("salaries", bytes);

////        取出文件内的数据并分组
//        Map<String, List<Integer>> salarieMap = Files.readAllLines(Paths.get("salaries"), Charset.defaultCharset())
//                .stream().filter(ss -> Integer.parseInt(ss.substring(6, ss.lastIndexOf(","))) > 10 * W)
//                .collect(
//                        groupingBy(s -> s.substring(0, 2), mapping(s1 -> Integer.parseInt(s1.substring(6, s1.lastIndexOf(","))), toList())));
////        排序
//        Object[] objects = salarieMap
//                .entrySet()
//                .stream()
//                .sorted(
//                        (f1, f2) ->
//                                Long.compare(f2.getValue().stream().mapToInt(Integer::intValue).sum()
//                                        , f1.getValue().stream().mapToInt(Integer::intValue).sum()))
//                .limit(10).map(
//                        keys -> new String(keys.getKey() + "," + keys.getValue().stream().mapToInt(Integer::intValue).sum() + "," + keys.getValue().stream().count()))
//                .toArray();

//        System.out.println(Arrays.toString(objects));
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

    public static int convertirOctetEnEntier(byte b1, byte b2, byte b3, byte b4) {
        int MASK = 0xFF;
        int result = 0;
        result = b4 & MASK;
        result = result + ((b3 & MASK) << 8);
        result = result + ((b2 & MASK) << 16);
        result = result + ((b1 & MASK) << 24);
        return result;
    }

    public static List<String> read(String paths) throws IOException {
        FileInputStream in = new FileInputStream(paths);
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);// 创建缓存区
            FileChannel fc = in.getChannel();
            byte[] bytes = new byte[140000];
            int index = 0;
            while (fc.read(byteBuffer) != -1) {// 读取字符以缓存区
                byteBuffer.flip();// 反转缓存区，很重要的方法
                while (byteBuffer.hasRemaining())// 判断是否还有可读取的字节
                    bytes[index++] = byteBuffer.get();
                byteBuffer.clear();// 清除缓存区，很重要的方法
            }
            return readAllLines(bytes);
        } finally {
            in.close();
        }
    }

    // after the process is run, we call this method with the String
    public static List<String> readAllLines(byte[] data) throws IOException {
        List<String> result = new ArrayList<>();
//        byte[] bytes = new byte[13];
//        for (; ; ) {
////            TODO  循环判断是否有 \n ，有的话可以认为是换行，截断拷贝出来
//            if (line == null)
//                break;
//            result.add(line);
//        }
        return result;
    }
}
