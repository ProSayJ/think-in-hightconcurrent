package prosayj.thinking.hightconcurrent._03_threadsafety;

import lombok.Data;
import prosayj.thinking.hightconcurrent._03_threadsafety.base.NumberOperator;
import prosayj.thinking.hightconcurrent._03_threadsafety.base.NumberOperatorThread;

import java.util.ArrayList;
import java.util.List;

/**
 * 不安全的线程操作
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:28
 */
@Data
public class ThreadUnsafe {
    public static void main(String[] args) throws InterruptedException {
        NumberOperator numberOperator = new NumberOperator();
        List<NumberOperatorThread> threads = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            NumberOperatorThread thread = new NumberOperatorThread(numberOperator);
            threads.add(thread);
            thread.start();
        }
        //线程完全结束以后，主线程才结束
        for (NumberOperatorThread thread : threads) {
            thread.join();
        }
        System.out.println(numberOperator.getI());
    }
}