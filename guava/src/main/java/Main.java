import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by moon on 16/6/14.
 *
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
//        Cache<Key, Value> cache = CacheBuilder.newBuilder()
//                .maximumSize(1000)
//                .build(); // look Ma, no CacheLoader
////        ...
//        try {
//            // If the key wasn't in the "easy to compute" group, we need to
//            // do things the hard way.
//            cache.get(key, new Callable<Value>() {
//                @Override
//                public Value call() throws AnyException {
//                    return doThingsTheHardWay(key);
//                }
//            });
//        } catch (ExecutionException e) {
//            throw new OtherException(e.getCause());
//        }


//        LoadingCache<String,String> cahceBuilder= CacheBuilder
//                .newBuilder()
//                .build(
//                        new CacheLoader<String, String>(){
//                    @Override
//                    public String load(String key) throws Exception {
//                        String strProValue="hello "+key+"!";
//                        return strProValue;
//                    }
//
//                }
//                );
//
//        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
//
        Cache<Object, Object> sessionCache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS).build();
//
//        sessionCache.containsKey

        sessionCache.put("111", "1212");
        int ikkk = 0;
        long starttime = System.currentTimeMillis();
        while (true) {
            if (sessionCache.asMap().containsKey("111")) {
                System.out.println(ikkk + " ---- " + (System.currentTimeMillis()-starttime));
                ikkk++;
            }
        }
//        while (true) {
//            /**
//             * 生成二维码券号
//             */
//            long time = System.currentTimeMillis();
//            String currentTime = String.valueOf(time);
//            String ssss = getFinalString(currentTime.substring(1));
//            System.out.println(ssss);
//        }

    }

    /**
     * 在当前时间字符串后面加上3个随机数
     *
     * @return
     */
    public static String getFinalString(String currentTime) {
        String end = "";
        Random rnd = new Random();
        for (int i = 0; i < 3; i++) {
            end += rnd.nextInt(10);
        }
        return currentTime + end;
    }


}
