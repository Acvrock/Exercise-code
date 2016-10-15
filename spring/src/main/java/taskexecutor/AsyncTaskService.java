package taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by moon on 15/10/2016.
 *
 * @Description:
 */
@Service
public class AsyncTaskService {

    @Async
    public void  executeAsyncTask(Integer i){
        System.out.println("执行异步任务：" + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1:" + (i + 1));
    }
}
