package com.acvrock.s1;

import java.util.Scanner;

/**
 * Created by moon on 17/12/2016.
 *
 * @Description:
 */
public class S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一段文字,按回车结束:\n");
        String in = sc.nextLine();
        System.out.print("请选择需要的组合，以英文逗号分割，如:1,3 按回车确认:\n" +
                "       1 ：加密\n" +
                "       2 ：反转字符串\n" +
                "       3：转成大写\n" +
                "       4：转成小写\n" +
                "       5：扩展或者剪裁到10个字符，不足部分用！补充\n");
        String style = sc.nextLine();
        String[] split = style.split(",");
        Decorator decorator = null;

        for (String s : split) {
            switch (s) {
                case "1":
                    EncryptCreator encryptCreator = new EncryptCreator(decorator);
                    decorator = encryptCreator;
                    break;
                case "2":
                    ReverseCreator reverseCreator = new ReverseCreator(decorator);
                    decorator = reverseCreator;
                    break;
                case "3":
                    UpperCaseCreator upperCaseCreator = new UpperCaseCreator(decorator);
                    decorator = upperCaseCreator;
                    break;
                case "4":
                    LowerCaseCreator lowerCaseCreator = new LowerCaseCreator(decorator);
                    decorator = lowerCaseCreator;
                    break;
                case "5":
                    RoundTenCreator roundTenCreator = new RoundTenCreator(decorator);
                    decorator = roundTenCreator;
                    break;
                default:
                    System.out.println("输入错误");

            }
        }

        System.out.println(decorator.handleContent(in));
    }


}
