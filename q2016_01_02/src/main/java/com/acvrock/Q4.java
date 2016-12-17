package com.acvrock;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Created by moon on 12/12/2016.
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
    static final String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


    public static void main(String[] args) throws IOException {
        Salary[] salaries = new Salary[10000];
        Random random = new Random();
//        生成数组
        byte[] bytes = Arrays.stream(salaries).map(salary -> {
                    salary = new Salary();
                    salary.setBaseSalary(random.nextInt(BASESALARYRYBOUND) + BASESALARYMIN);
                    salary.setBonus(random.nextInt(BOUNDBOUND));
                    StringBuffer buf = new StringBuffer();
                    for (int i = 0; i < 5; i++) {
                        int num = random.nextInt(62);
                        buf.append(str.charAt(num));
                    }
                    salary.setName(buf.toString());
                    return salary;
                }
        ).reduce(new StringBuilder(), (s1, s2) -> s1.append(s2).append('\n'), StringBuilder::append).toString().getBytes();

//        存进文件
        write("salaries", bytes);

//        取出文件内的数据并分组
        Map<String, List<Integer>> salarieMap = Files.readAllLines(Paths.get("salaries"), Charset.defaultCharset())
                .stream()
                .collect(
                        groupingBy(s -> s.substring(0, 2),
                                mapping(s1 -> Integer.parseInt(s1.substring(6, s1.lastIndexOf(","))),
                                        toList())));
//        排序
        Object[] objects = salarieMap
                .entrySet()
                .stream()
                .sorted(
                        (f1, f2) ->
                                Long.compare(f2.getValue().stream().mapToInt(Integer::intValue).sum()
                                        , f1.getValue().stream().mapToInt(Integer::intValue).sum()))
                .limit(10).map(
                        keys -> new String(keys.getKey() + "," + keys.getValue().stream().mapToInt(Integer::intValue).sum() + "," + keys.getValue().stream().count()))
                .toArray();

        System.out.println(Arrays.toString(objects));

    }

    static class Salary implements Comparable {
        private String name;
        private int baseSalary;
        private int bonus;

        public int compareTo(Object o) {
            Salary salary = (Salary) o;
            return Integer.compare(salary.getBaseSalary() * 13 + salary.getBonus(), baseSalary * 13 + bonus);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setBaseSalary(int baseSalary) {
            this.baseSalary = baseSalary;
        }

        public void setBonus(int bonus) {
            this.bonus = bonus;
        }

        public String getName() {
            return name;
        }

        public int getBaseSalary() {
            return baseSalary;
        }

        public int getBonus() {
            return bonus;
        }

        @Override
        public String toString() {
            return name + ',' + baseSalary + "," + bonus;
        }
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
}
