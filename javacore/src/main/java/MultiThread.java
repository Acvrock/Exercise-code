import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by moon on 6/16/16.
 *
 * @Description: 打印出 JVM 线程信息
 */
public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for(ThreadInfo threadInfo :threadInfos){
            System.out.println(threadInfo.getThreadId()+threadInfo.getThreadName());
        }

    }
}
