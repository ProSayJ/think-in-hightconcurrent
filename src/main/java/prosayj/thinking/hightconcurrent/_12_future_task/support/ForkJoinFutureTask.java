package prosayj.thinking.hightconcurrent._12_future_task.support;

import java.util.concurrent.Callable;

/**
 * ForkJoinFutureTask
 *
 * @author yangjian
 * @date 2021-02-10 上午 10:50
 * @since 1.0.0
 */
public class ForkJoinFutureTask implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        System.out.println("before fun");
        fun();
        System.out.println("after fun");
        return null;
    }
    public void fun() {
        while (true) {

        }
    }
}
