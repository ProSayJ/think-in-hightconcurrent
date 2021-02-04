package prosayj.thinking.hightconcurrent._04_threadsynchronized;

/**
 * 类锁的另外一种形式：互斥
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:49
 */
public class SynchronizeDemo5 {
    static class Runnable1 implements Runnable {
        @Override
        public void run() {
            synchronized (SynClass2.class) {
                System.out.println(Thread.currentThread().getName() + "-myRun");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-myRun");
            }
        }
    }

    static class Runnable2 implements Runnable {
        @Override
        public void run() {
            synchronized (SynClass2.class) {
                System.out.println(Thread.currentThread().getName() + "-myRun2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-myRun2");
            }
        }
    }

    public static void main(String[] args) {
        Runnable1 runnable1 = new Runnable1();
        Runnable2 runnable2 = new Runnable2();
        Thread thread1 = new Thread(runnable1);
        thread1.setName("thread1");
        Thread thread2 = new Thread(runnable2);
        thread2.setName("thread2");
        thread1.start();
        thread2.start();
    }
}

class SynClass2 {
}
