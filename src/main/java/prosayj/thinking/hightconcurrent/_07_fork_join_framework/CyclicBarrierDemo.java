package prosayj.thinking.hightconcurrent._07_fork_join_framework;

import prosayj.thinking.hightconcurrent._07_fork_join_framework.support.ForkJoinCyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierDemo
 * <p>
 * 线程3等到线程1和线程2同时到达屏障后，才执行，这个时候，取到的num就是2了。
 * 线程2休眠了1秒，线程1休眠了5秒，但是线程2并没有先执行，所以他是在等线程1到达屏障。
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/9 23:29
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        Integer num = 0;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new ForkJoinCyclicBarrier("t3", null, null, null));
        new ForkJoinCyclicBarrier("t1", cyclicBarrier, num, 5000L).start();
        new ForkJoinCyclicBarrier("t2", cyclicBarrier, num, 1000L).start();
        System.out.println(Thread.currentThread().getName() + ":num=" + num);
    }


}
