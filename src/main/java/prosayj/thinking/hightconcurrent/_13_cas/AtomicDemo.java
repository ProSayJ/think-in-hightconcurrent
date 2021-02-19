package prosayj.thinking.hightconcurrent._13_cas;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    static int num1 = 0;
    static AtomicInteger num2 = new AtomicInteger(0);

    static class Thread1 extends Thread {
        @Override
        public void run() {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num1++;
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num2.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread1().start();
            new Thread2().start();
        }
        Thread.sleep(2000);
        System.out.println("num1=" + num1);
        System.out.println("num2=" + num2.get());
    }
}