package t20170102;

import java.util.Date;

/**
 * Created by moon on 02/01/2017.
 *
 * @Description:
 * 反射的基石：Class 类
 * Class clazz1 = Date.class
 * Class clazz2 = new Date().getClass()
 * Class.forName("java.util.Date");
 *
 *
 * java 内置九个Class 实例对象
 * 参考 Class.isPrimitive
 * int.class  == Integer.TYPE
 * 数组类型的Class 实例对象
 * Class.isArray
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Date date = new Date();
        Class<? extends Date> class1 = date.getClass();
        Class<Date> class2 = Date.class;
        Class<?> class3 = Class.forName("java.util.Date");
        System.out.println(class1 == class2);
        System.out.println(class1 == class3);

        System.out.println(class1.isPrimitive());
        System.out.println(int.class.isPrimitive());
        System.out.println(int.class == Integer.class);
        System.out.println(int.class == Integer.TYPE);
        System.out.println(int[].class.isPrimitive());
        System.out.println(int[].class.isArray());
    }
}
