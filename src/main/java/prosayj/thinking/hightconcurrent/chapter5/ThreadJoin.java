package prosayj.thinking.hightconcurrent.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Thread的join方法详细介绍
 *
 * @author yangjian201127@credithc.com
 * @date 2021-02-03 下午 05:40
 * @since 1.0.0
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        //测试 join 方法:阻塞当前线程，直到该线程执行结束
//        m1();
        //join方法协同线程
        m2();


        //interrupt、isInterrupted：判断当前线程是否被中断
//        m3();
    }

    private static void m3() {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 is running");
            while (true) {
                System.out.println("isInterrupted==>" + Thread.currentThread().isInterrupted());
            }
        }, "t1");


        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3_000);
                //中断当前线程(t1)
                t1.interrupt();
                System.out.println("interrupt");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "t2");

        t1.setDaemon(true);
        t1.start();
        t2.start();

        try {
            t1.join(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private static void m2() throws InterruptedException {
        long startTimestamp = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1", 10_000L));
        Thread t2 = new Thread(new CaptureRunnable("M2", 12_000L));
        Thread t3 = new Thread(new CaptureRunnable("M3", 15_000L));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long endTimestamp = System.currentTimeMillis();
        System.out.printf("Save data begin timestamp is:%s, end timestamp is:%s\n", startTimestamp, endTimestamp);
    }


    /**
     * join方法：阻塞当前线程，直到该线程执行结束
     */
    private static void m1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            IntStream.range(1, 50)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        }, "t1") {{
            start();
            join();
        }};
        Thread t2 = new Thread(() -> {
            IntStream.range(1, 50)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        }, "t2") {{
            start();
            join();
        }};

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 50).forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
    }

    static class CaptureRunnable implements Runnable {

        private final String machineName;

        private final long spendTime;

        public CaptureRunnable(String machineName, long spendTime) {
            this.machineName = machineName;
            this.spendTime = spendTime;
        }

        @Override
        public void run() {
            //do the really capture data.
            try {
                Thread.sleep(spendTime);
                System.out.printf(machineName + " completed data capture at timestamp [%s] and successfully.\n", System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String getResult() {
            return machineName + " finish.";
        }
    }
}
