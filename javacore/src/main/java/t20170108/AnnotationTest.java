package t20170108;

/**
 * Created by moon on 08/01/2017.
 *
 * @Description:
 */
@IAnnotation(annotationAttr = @MetaAnnotation("flx"), color = "blud",value="kkk")
public class AnnotationTest {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        System.runFinalizersOnExit(true);
        System.out.println(AnnotationTest.class.isAnnotationPresent(IAnnotation.class));
        if(AnnotationTest.class.isAnnotationPresent(IAnnotation.class)){
            IAnnotation annotation = AnnotationTest.class.getAnnotation(IAnnotation.class);
            System.out.println(annotation.color());
            System.out.println(annotation.arrayAttr().length);
            System.out.println(annotation.annotationAttr().value());
        }
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
