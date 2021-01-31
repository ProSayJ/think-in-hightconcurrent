package prosayj.thinking.hightconcurrent.chapter2;

/**
 * TicketWindow
 *
 * @author yangjian
 * @date 2021-02-01 上午 01:06
 * @since 1.0.0
 */
public class TicketWindow extends Thread {

    /**
     * 售票窗口柜台名称
     */
    private final String name;

    /**
     * 最大号码
     */
    private static final int MAX = 50;

    /**
     * 第一个号码
     */
    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + name + "当前的号码是:" + (index++));
        }
    }
}
