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
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        boolean await = false;
        System.out.println(Thread.currentThread().getName() + "：start~~~");
        new ForkJoinCountDownLatch("t1", countDownLatch).start();
        new ForkJoinCountDownLatch("t2", countDownLatch).start();
        new ForkJoinCountDownLatch("t3", countDownLatch).start();
        new ForkJoinCountDownLatch("t4", countDownLatch).start();
        new ForkJoinCountDownLatch("t5", countDownLatch).start();
        try {
            await = countDownLatch.await(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "：end~~~,等待结果是：" + (await ? "等待子任务执行都执行完了" : "等不及了~~~"));
    }
}
