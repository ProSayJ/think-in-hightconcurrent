package prosayj.thinking.hightconcurrent._07_fork_join_framework;

import prosayj.thinking.hightconcurrent._07_fork_join_framework.support.ForkJoinCountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-02-09 下午 06:28
 * @since 1.0.0
 */
public class CountDownLatchDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {
        new ForkJoinCountDownLatch("t1", countDownLatch).start();
        new ForkJoinCountDownLatch("t2", countDownLatch).start();
        new ForkJoinCountDownLatch("t3", countDownLatch).start();
        new ForkJoinCountDownLatch("t4", countDownLatch).start();
        new ForkJoinCountDownLatch("t5", countDownLatch).start();
        try {
            countDownLatch.await(5_000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("等不及了~~~");
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + 3);
    }
}
