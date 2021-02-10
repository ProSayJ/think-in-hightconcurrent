package prosayj.thinking.hightconcurrent._07_fork_join_framework.support;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ForkJoinCyclicBarrier
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/9 23:24
 */
public class ForkJoinCyclicBarrier extends Thread {
    private final CyclicBarrier cyclicBarrier;
    private final Long loopTimes;
    private final AtomicReference<Integer> num;


    public ForkJoinCyclicBarrier(String threadName, CyclicBarrier cyclicBarrier, AtomicReference<Integer> num, Long loopTimes) {
        super(threadName);
        this.cyclicBarrier = cyclicBarrier;
        this.num = num;
        this.loopTimes = loopTimes;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start~~");
        try {
            long startTime = System.currentTimeMillis();

            for (int i = 0; i < loopTimes; i++) {
                num.updateAndGet(value -> value + 1);
            }

            System.out.println(Thread.currentThread().getName() +
                    " end~~ 结果是：" + num.get() +
                    "共耗时：" + (System.currentTimeMillis()-startTime) + "ms~~");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
