package prosayj.thinking.hightconcurrent._05_threadlocal.support;

import java.util.concurrent.Callable;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-02-05 上午 11:20
 * @since 1.0.0
 */
public class ThreadLocalNumberOperatorThread implements Callable<Integer> {
    private final ThreadLocalNumberOperator threadLocalNumberOperator;

    public ThreadLocalNumberOperatorThread(ThreadLocalNumberOperator threadLocalNumberOperator) {
        this.threadLocalNumberOperator = threadLocalNumberOperator;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 1000; i++) {
            threadLocalNumberOperator.increasing();
        }
        return threadLocalNumberOperator.getI();
    }
}
