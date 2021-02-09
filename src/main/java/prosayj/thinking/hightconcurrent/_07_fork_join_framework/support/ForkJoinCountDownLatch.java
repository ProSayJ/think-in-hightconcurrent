package prosayj.thinking.hightconcurrent._07_fork_join_framework.support;

import java.util.concurrent.CountDownLatch;

/**
 * ForkJoinCountDownLatch
 *
 * @author yangjian
 * @date 2021-02-09 下午 06:39
 * @since 1.0.0
 */
public class ForkJoinCountDownLatch extends Thread {
    private final CountDownLatch countDownLatch;

    public ForkJoinCountDownLatch(String threadName, CountDownLatch countDownLatch) {
        super(threadName);
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "：start~~~");
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "：end~~~");
        countDownLatch.countDown();
    }

}
