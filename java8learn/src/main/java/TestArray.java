import java.util.Arrays;
import java.util.List;

/**
 * Created by moon on 22/11/2016.
 *
 * @Description:
 */
public class TestArray {

    public static void main(String[] args) {
        int tags = 4;

        Byte[] data = new Byte[]{38, 0, 10, 12, 8, 12, 18, 1, 49, 26, 22, 8, 0, 16, 1, 34, 16, 8, 1, 16, 5, 24, 2, 34, 8, 8, 1, 26, 4, 50, 52, 46, 53, 33, -58, 116, -23, -102, 84, 1, 0, 0, 35, 0, 10, 12, 8, 12, 18, 1, 49, 26, 19, 8, 0, 16, 2, 34, 13, 8, 1, 16, 5, 24, 2, 34, 5, 8, 1, 26, 1, 49, 33, -9, 116, -23, -102, 84, 1, 0, 0};
        System.out.println(data.length);
        List<Byte> bytes = Arrays.asList(data);
        int bytes1to = bytes.get(0) + tags;
        List<Byte> bytes1 = bytes.subList(0, bytes1to);
        System.out.println(bytes1.toString());
        System.out.println(bytes1.size());

        int bytes2to = bytes.get(bytes1to) + tags;
        List<Byte> bytes2 = bytes.subList(bytes1to, bytes1to + bytes2to);
        System.out.println(bytes2.toString());
        System.out.println(bytes2.size());


    }

}
