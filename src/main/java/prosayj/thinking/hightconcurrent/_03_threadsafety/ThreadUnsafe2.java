package prosayj.thinking.hightconcurrent._03_threadsafety;

import lombok.Data;
import prosayj.thinking.hightconcurrent._03_threadsafety.support.NumberOperator;
import prosayj.thinking.hightconcurrent._03_threadsafety.support.NumberOperatorThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 不安全的线程操作
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:28
 */
@Data
public class ThreadUnsafe2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        NumberOperator numberOperator = new NumberOperator();
        List<Thread> tasks = new ArrayList<>(1000);


        for (int i = 0; i < 1000; i++) {
            tasks.add(new NumberOperatorThread(numberOperator) {{
                start();
                System.out.println(Thread.currentThread().getName());
                //结果始终是:1000000 为什么呢？
                // 这个join是不是加入到main线程？
                join();
            }});
        }
        for (Thread task : tasks) {
//            task.join();
        }
        System.out.println(numberOperator.getI());
    }
}