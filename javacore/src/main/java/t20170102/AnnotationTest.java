package t20170102;

/**
 * Created by moon on 08/01/2017.
 *
 * @Description:
 */
public class AnnotationTest {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        System.runFinalizersOnExit(true);
    }

    @Deprecated
    public static void sayHello() {
        System.out.println("dd");
    }

    public AnnotationTest() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
