package prosayj.thinking.hightconcurrent.chapter4;

/**
 * 守护线程
 * 守护线程随着主线程的结束而结束
 *
 * @author yangjian
 * @date 2021-02-02 上午 07:20
 * @since 1.0.0
 */
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {

        //守护线程随着主线程的结束而结束
       // test1();
        //守护线程的作用之一：监控检查
        test2();


    }

    private static void test2() {
        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Do some thing for health check.");
                        Thread.sleep(1_000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            innerThread.setDaemon(true);
            innerThread.start();
            try {
                Thread.sleep(10_000);
                System.out.println("T thread finish done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        t.setDaemon(true);
        t.start();

    }

    private static void test1() throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " running");
                Thread.sleep(10_000);
                System.out.println(Thread.currentThread().getName() + " done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //t.setDaemon(true);
        t.start();
        //runnable  ->running| ->dead| ->blocked

        // JDK1.7
        Thread.sleep(5_000);
        System.out.println(Thread.currentThread().getName());
    }
}