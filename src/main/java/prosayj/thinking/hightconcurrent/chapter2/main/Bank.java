package prosayj.thinking.hightconcurrent.chapter2.main;

import prosayj.thinking.hightconcurrent.chapter2.TicketWindow;

/**
 * Bank
 *
 * @author yangjian
 * @date 2021-02-01 上午 01:06
 * @since 1.0.0
 */
public class Bank {
    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("一号柜台");
        ticketWindow1.start();

        TicketWindow ticketWindow2 = new TicketWindow("二号柜台");
        ticketWindow2.start();

        TicketWindow ticketWindow3 = new TicketWindow("三号柜台");
        ticketWindow3.start();

    }
}
