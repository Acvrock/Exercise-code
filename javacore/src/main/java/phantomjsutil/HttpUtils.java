package phantomjsutil;

/**
 * Created by moon on 8/17/16.
 *
 * @Description:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class HttpUtils {
    public static String getAjaxCotnent(String url) throws IOException {
        Runtime rt = Runtime.getRuntime();
        //phantomjs 和codes.js的路径之间有个空格 本代码只是测试用的绝对路径
        Process p = rt.exec("phantomjs /Users/moon/GitHub/Exercise-code/javacore/src/main/java/phantomjsutil/open.js "+url);
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sbf = new StringBuffer();
        String tmp = "";
        while((tmp = br.readLine())!=null){
            sbf.append(tmp);
        }
        //System.out.println(sbf.toString());
        return sbf.toString();
    }

    public static void main(String[] args) throws IOException {
        String content = getAjaxCotnent("http://cq.qq.com/baoliao/detail.htm?294064");
      System.out.print(content);
        assert  content != null;
    }
}