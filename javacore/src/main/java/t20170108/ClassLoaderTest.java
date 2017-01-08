package t20170108;

/**
 * Created by moon on 08/01/2017.
 *
 * @Description:
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
//        System.out.println(ClassLoaderTest.class.getClassLoader().getClass().getName());
//        System.out.println(System.class.getClassLoader().getClass().getName());
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        while (classLoader!=null){
            System.out.println(classLoader.getClass().getName());
            classLoader=  classLoader.getParent();
        }
    }
}
