package prosayj.thinking.hightconcurrent._09_cyclic_barrier;

import prosayj.thinking.hightconcurrent._09_cyclic_barrier.support.ForkJoinCyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicReference;

/**
 * CyclicBarrierDemo
 * <p>
 * cyclicBarrier线程内的代码块，等到线程t1和线程t2同时到达屏障后，才执行，这个时候，取到的num就是最终的结果了。
 * 线程2休眠了1秒，线程1休眠了5秒，但是线程2并没有先执行，所以他是在等线程1到达屏障。
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/9 23:29
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " start~~");
        AtomicReference<Integer> num = new AtomicReference<>(0);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,
                () -> System.out.println("cyclicBarrier开始执行，获取最终结果是：" + num.get()));


        new ForkJoinCyclicBarrier("t1", cyclicBarrier, num, 700000L).start();
        new ForkJoinCyclicBarrier("t2", cyclicBarrier, num, 500000L).start();
        new ForkJoinCyclicBarrier("t3", cyclicBarrier, num, 300000L).start();
        new ForkJoinCyclicBarrier("t4", cyclicBarrier, num, 100000L).start();

        System.out.println(Thread.currentThread().getName() + " end~~ 结果是：" + num.get());
    }


}
