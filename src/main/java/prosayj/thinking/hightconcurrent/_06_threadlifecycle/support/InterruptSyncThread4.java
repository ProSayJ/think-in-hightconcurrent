package prosayj.thinking.hightconcurrent._06_threadlifecycle.support;

/**
 * 没有抛异常
 *
 * @author yangjian201127@credithc.com
 * @date 2021-02-09 下午 05:16
 * @since 1.0.0
 */
public class InterruptSyncThread4 extends Thread {
    @Override
    public void run() {
        syncFun();
    }

    public static synchronized void syncFun() {
        while (true) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptSyncThread4 thread = new InterruptSyncThread4();
        InterruptSyncThread4 thread2 = new InterruptSyncThread4();
        thread.start();
        sleep(1000);
        thread2.start();
        sleep(1000);

        System.out.println(thread.getState());
        System.out.println(thread2.getState());

        thread2.interrupt();
        sleep(1000);
        System.out.println(thread2.getState());
        System.out.println(thread2.isInterrupted());
    }
}
