package prosayj.thinking.hightconcurrent.chapter6;

/**
 * Thread中断Interrupt方法详细讲解
 *
 * @author yangjian201127@credithc.com
 * @date 2021-02-04 上午 04:58
 * @since 1.0.0
 */
public class ThreadInterrupt {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {
        //
//        m1();
        m2();


        //当t1被t2join，并且t1发生了interrupt时的情况。
//        m00221();
//        m3();


    }

    /**
     * interrupt基本用法，
     */
    private static void m1() {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                System.out.println("休眠被打断:==>" + Thread.interrupted());
                e.printStackTrace();
            }
        });
        t1.start();
        System.out.println("t1.isInterrupted() = " + t1.isInterrupted());
        t1.interrupt();
        System.out.println("t1.isInterrupted() = " + t1.isInterrupted());

    }

    private static void m3() {
        Thread thread = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    try {
                        MONITOR.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(Thread.interrupted());
                    }
                }
            }
        });
        thread.start();
        thread.notify();
    }

    /**
     * 错误的
     */
    private static void m2() throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (MONITOR) {
                    while (true) {
                        System.out.println("中断异常" + isInterrupted());
                        try {
                            MONITOR.wait(2_000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println("中断异常" + isInterrupted());
                            if (isInterrupted()) {
                                break;
                            }
                        }
                    }
                }
            }
        };
        t1.start();
        Thread.sleep(100);
        System.out.println("t1.isInterrupted()==>" + t1.isInterrupted());
        t1.interrupt();
        System.out.println("t1.isInterrupted()==>" + t1.isInterrupted());
        Thread.sleep(100);
    }

    /**
     * 当t1被t2join，并且t1发生了interrupt时的情况。
     * 会抛出异常
     */
    private static void m00221() {
        Thread t1 = new Thread(() -> {
            while (true) {
            }
        });
        t1.start();

        Thread main = Thread.currentThread();
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            main.interrupt();
            System.out.println("interrupt");
        });

        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
