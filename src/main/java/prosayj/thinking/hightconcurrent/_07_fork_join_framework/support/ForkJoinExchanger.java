package prosayj.thinking.hightconcurrent._07_fork_join_framework.support;

import java.util.concurrent.Exchanger;

/**
 * ForkJoinExchanger
 * 用来交换两个线程的数据。
 *
 * @author yangjian
 * @date 2021-02-10 上午 10:42
 * @since 1.0.0
 */
public class ForkJoinExchanger extends Thread {
    private final Exchanger<String> exchanger;
    private final String changeStringValue;

    public ForkJoinExchanger(String name, String changeStringValue, Exchanger<String> exchanger) {
        super(name);
        this.exchanger = exchanger;
        this.changeStringValue=changeStringValue;
    }

    @Override
    public void run() {
        try {
            //只有t2线程会耗时3s
            if ("t2".equalsIgnoreCase(Thread.currentThread().getName())) {
                sleep(3_000);
            }
            String str = exchanger.exchange(changeStringValue);
            System.out.println(Thread.currentThread().getName() + "-" + str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
