package prosayj.thinking.hightconcurrent._05_threadlocal;

import prosayj.thinking.hightconcurrent._05_threadlocal.support.ThreadLocalNumberOperator;
import prosayj.thinking.hightconcurrent._05_threadlocal.support.ThreadLocalNumberOperatorThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-02-05 上午 11:22
 * @since 1.0.0
 */
public class ThreadLocalSafe {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalNumberOperator numberOperator = new ThreadLocalNumberOperator();
        List<FutureTask<Integer>> threads = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            FutureTask<Integer> futureTask = new FutureTask<>(new ThreadLocalNumberOperatorThread(numberOperator));
            threads.add(futureTask);
            new Thread(futureTask) {{
                start();
                join();
            }};
        }
        System.out.println(numberOperator.getI());
        //线程完全结束以后，主线程才结束
        for (FutureTask<Integer> task : threads) {
            try {
                System.out.println(task.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
