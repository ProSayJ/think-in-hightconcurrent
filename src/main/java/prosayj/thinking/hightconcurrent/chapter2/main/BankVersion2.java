package prosayj.thinking.hightconcurrent.chapter2.main;

import prosayj.thinking.hightconcurrent.chapter2.TicketWindowRunnable;

/**
 * BankVersion2
 *
 * @author yangjian
 * @date 2021-02-01 上午 01:06
 * @since 1.0.0
 */
public class BankVersion2 {
    private final static int MAX = 50;
    private static int index = 1;


    public static void main(String[] args) {
//        final TicketWindowRunnable ticketWindow = new TicketWindowRunnable();
        final Runnable ticketWindow = () -> {

            while (index <= MAX) {
                synchronized (BankVersion2.class) {
                    System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(ticketWindow, "一号窗口").start();
        new Thread(ticketWindow, "二号窗口").start();
        new Thread(ticketWindow, "三号窗口").start();
    }
}
