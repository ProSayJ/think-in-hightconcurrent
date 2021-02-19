package prosayj.thinking.hightconcurrent._08_count_down_latch.support;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ForkJoinCountDownLatch
 *
 * @author yangjian
 * @date 2021-02-09 下午 06:39
 * @since 1.0.0
 */
public class ForkJoinCountDownLatch extends Thread {
    private final CountDownLatch countDownLatch;
    private final AtomicReference<Integer> num;

    public ForkJoinCountDownLatch(String threadName, CountDownLatch countDownLatch, AtomicReference<Integer> num) {
        super(threadName);
        this.countDownLatch = countDownLatch;
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：start~~~");
        for (int i = 0; i < 100000; i++) {
            num.updateAndGet(value -> value + 1);
        }
        System.out.println(Thread.currentThread().getName() + "：end~~~");
        countDownLatch.countDown();
    }

}
