package prosayj.thinking.hightconcurrent._07_fork_join_framework;

import prosayj.thinking.hightconcurrent._07_fork_join_framework.support.ForkJoinCountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * CountDownLatchDemo
 *
 * @author yangjian
 * @date 2021-02-09 下午 06:28
 * @since 1.0.0
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        boolean await = false;
        AtomicReference<Integer> result = new AtomicReference<>(0);
        System.out.println(Thread.currentThread().getName() + "：start~~~");
        new ForkJoinCountDownLatch("t1", countDownLatch, result).start();
        new ForkJoinCountDownLatch("t2", countDownLatch, result).start();
        new ForkJoinCountDownLatch("t3", countDownLatch, result).start();
        new ForkJoinCountDownLatch("t4", countDownLatch, result).start();
        new ForkJoinCountDownLatch("t5", countDownLatch, result).start();
        try {
            await = countDownLatch.await(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +
                (await ? ":等待子任务执行都执行完了 " : ":等不及了 ") +
                "end~~~,计算结果是：" + result.get());
    }
}
