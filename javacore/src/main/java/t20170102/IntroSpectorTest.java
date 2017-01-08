package t20170102;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by moon on 08/01/2017.
 *
 * @Description:  PropertyDescriptor 可以获取 JavaBean 成员变量的 get 和 set 方法

 */
public class IntroSpectorTest {

    private static class A {
        int a;
        String s;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        public A(int a, String s) {
            this.a = a;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        A a = new A(121, "hello");
        String propertyName = "a";
        Object retVal = getProperty(a, propertyName);
        System.out.println(retVal);

        Object value = 3;
        setProperties(a,propertyName,value);
        System.out.println(a.getA());

        BeanInfo beanInfo = Introspector.getBeanInfo(a.getClass());  // 获取类对象的信息
        System.out.println(Arrays.asList(beanInfo.getPropertyDescriptors()));
    }

    private static void setProperties(Object a,String propertyName,Object value) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, a.getClass());
        Method writeMethod = propertyDescriptor.getWriteMethod();
        writeMethod.invoke(a,value);
    };

    private static Object getProperty(Object a, String propertyName) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, a.getClass());
        Method readMethod = propertyDescriptor.getReadMethod();
        return readMethod.invoke(a);
    }

}



