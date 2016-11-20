/**
 * Created by moon on 20/11/2016.
 *
 * @Description: 不应该使用 x-y 来比较 x 和 y 的大小，因为有溢出风险
 */
public class java7compare {

    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE;
        int minValue = -1;
        if ((maxValue - minValue) > 0) {
            System.out.println(maxValue + "大于" + minValue);
        } else {
            System.out.println(minValue + "大于" + maxValue);
        }
    }
}
