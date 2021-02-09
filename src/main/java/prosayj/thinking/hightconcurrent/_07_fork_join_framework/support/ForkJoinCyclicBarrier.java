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
    private final Long costTime;
    private final AtomicReference<Integer> num;


    public ForkJoinCyclicBarrier(String threadName, CyclicBarrier cyclicBarrier, AtomicReference<Integer> num, Long costTime) {
        super(threadName);
        this.cyclicBarrier = cyclicBarrier;
        this.num = num;
        this.costTime = costTime;
    }

    @Override
    public void run() {
        if (cyclicBarrier == null) {
            System.out.println(Thread.currentThread().getName() + "(cyclicBarrier==null):num=" + num);
        } else {
            try {
                num.updateAndGet(v -> v + 1);
                Thread.sleep(costTime);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + ":num=" + num);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }
}
