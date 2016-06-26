import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by moon on 6/23/16.
 *
 * @Description:
 */
public class TestMapToString {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("index","1");
        hashMap.put("activity","1");
        hashMap.put("ticket","1");
        hashMap.put("search","1");
        hashMap.put("center","1");

        Gson gson =new Gson();
        System.out.println(gson.toJson(hashMap));
    }
}
