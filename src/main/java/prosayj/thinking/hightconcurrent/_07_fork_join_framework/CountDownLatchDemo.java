package prosayj.thinking.hightconcurrent._07_fork_join_framework;

import java.util.concurrent.CountDownLatch;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-02-09 下午 06:28
 * @since 1.0.0
 */
public class CountDownLatchDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + ":" + 1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + 2);
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        Thread thread =new Thread(new Thread1(),"thread");
        thread.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + 3);
    }
}
