package prosayj.thinking.hightconcurrent._07_fork_join_framework.support;

import java.util.concurrent.CountDownLatch;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-02-09 下午 06:39
 * @since 1.0.0
 */
public class ForkJoinCountDownLatch extends Thread{
    CountDownLatch countDownLatch;

    public ForkJoinCountDownLatch(String name, CountDownLatch countDownLatch) {
        super(name);
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        countDownLatch.countDown();
        System.out.println(Thread.currentThread().getName() + ":" + 1);
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + 2);
        countDownLatch.countDown();
    }

}
