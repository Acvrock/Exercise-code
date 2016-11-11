import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * Created by moon on 11/11/2016.
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config1.xml", "config2.xml"});
        Product product = context.getBean("product", Product.class);
        System.out.println(product.toString());

        Calendar calendar = context.getBean("calendar", Calendar.class);
        System.out.println(calendar.getTime());


        Product featuredProduct = context.getBean("featuredProduct", Product.class);
        System.out.println(featuredProduct.toString());

        Product featuredProduct2 = context.getBean("featuredProduct2", Product.class);
        System.out.println(featuredProduct2.toString());

        Topic topic = context.getBean("topic", Topic.class);
        System.out.println(topic.getProduct().equals(featuredProduct));
        System.out.println(topic.getProduct().equals(featuredProduct2));

        Topic topic2 = context.getBean("topic2", Topic.class);
        System.out.println(topic2.getProduct().equals(featuredProduct));
        System.out.println(topic2.getProduct().equals(featuredProduct2));
    }
}
