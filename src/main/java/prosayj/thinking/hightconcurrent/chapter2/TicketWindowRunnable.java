package prosayj.thinking.hightconcurrent.chapter2;

/**
 * TicketWindowRunnable
 *
 * @author yangjian
 * @date 2021-02-01 上午 01:06
 * @since 1.0.0
 */
public class TicketWindowRunnable implements Runnable {
    private int index = 1;
    private final static int MAX = 50;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
