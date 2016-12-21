import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * Created by moon on 21/12/2016.
 *
 * @Description:
 */

public class TestMain {

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass c = pool.get("com.seventh7.mybatis.util.JavaUtils");
        CtMethod m = c.getDeclaredMethod("refValid");
        m.setBody("{ validated = true; valid = true; return valid; }");
        c.writeFile();

        CtClass cc = pool.get("com.seventh7.mybatis.service.JavaService");
        CtMethod mm = cc.getDeclaredMethod("stop");
        mm.setBody("{ return; }");
        cc.writeFile();
    }

}