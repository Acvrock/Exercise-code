import java.io.Serializable;

/**
 * Created by moon on 11/11/2016.
 *
 * @Description:
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 8488423232L;

    private String name;
    private String description;
    private float price;

    public Product() {
    }

    public Product(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public static Product init() {
        System.out.println("Product init");
        return new Product();
    }

    public static void destroy() {
        System.out.println("Product destroy");
    }
}
