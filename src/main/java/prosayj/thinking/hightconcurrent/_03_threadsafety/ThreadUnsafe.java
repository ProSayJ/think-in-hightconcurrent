package prosayj.thinking.hightconcurrent._03_threadsafety;

import lombok.Data;
import prosayj.thinking.hightconcurrent._03_threadsafety.support.NumberOperator;
import prosayj.thinking.hightconcurrent._03_threadsafety.support.NumberOperatorCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 不安全的线程操作
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:28
 */
@Data
public class ThreadUnsafe {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        NumberOperator numberOperator = new NumberOperator();
        List<Thread> tasks = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new FutureTask<>(new NumberOperatorCallable(numberOperator))) {{
                System.out.println(Thread.currentThread().getName());
                start();
                join();
            }};
            tasks.add(thread);
        }

        for (Thread task : tasks) {
//            task.join();
        }
        System.out.println(numberOperator.getI());
    }
}