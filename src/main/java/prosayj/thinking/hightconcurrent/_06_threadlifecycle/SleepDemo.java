package prosayj.thinking.hightconcurrent._06_threadlifecycle;

/**
 * 线程的生命周期：sleep线程
 * <p>
 * main线程的两次时间相差1000毫秒，demo的两次时间相差2000毫秒，sleep只影响自己的线程运行，不影响其他线程。
 *
 * @author yangjian201127@credithc.com
 * @date 2021-02-06 下午 01:46
 * @since 1.0.0
 */
public class SleepDemo extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis());
    }

    public static void main(String[] args) {
        new SleepDemo() {{
            setName("demo");
            start();
        }};
        try {
            System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
