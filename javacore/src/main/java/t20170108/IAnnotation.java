package t20170108;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by moon on 08/01/2017.
 *
 * @Description: Retention 有三种取值：SOURCE/CLASS/RUNTIME 对于 Java 源文件、class 文件、内存中的字节码
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface IAnnotation {
    String color() default "red";
    String value();
    int[] arrayAttr() default{3,4,5};
    MetaAnnotation annotationAttr() default  @MetaAnnotation("fix");
}
