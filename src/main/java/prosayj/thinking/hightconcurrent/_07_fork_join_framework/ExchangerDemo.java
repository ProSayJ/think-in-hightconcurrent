package prosayj.thinking.hightconcurrent._07_fork_join_framework;

import prosayj.thinking.hightconcurrent._07_fork_join_framework.support.ForkJoinExchanger;

import java.util.concurrent.Exchanger;

/**
 * ExchangerDemo
 * <p>
 * 交换两个线程的数据
 *
 * @author yangjian
 * @date 2021-02-10 上午 10:45
 * @since 1.0.0
 */
public class ExchangerDemo {

    public static void main(String[] args) {
        //首先，会经过三秒后，才输出结果，说明两个线程没交换之前是阻塞的。输出结果可以看出，两个线程的字符串交换了
        Exchanger<String> exchanger = new Exchanger<>();
        new ForkJoinExchanger("t1", "a", exchanger).start();
        new ForkJoinExchanger("t2", "b", exchanger).start();
    }
}
