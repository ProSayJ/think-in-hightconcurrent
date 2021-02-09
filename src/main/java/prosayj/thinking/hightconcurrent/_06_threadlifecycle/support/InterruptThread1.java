package prosayj.thinking.hightconcurrent._06_threadlifecycle.support;

/**
 * 虽然中断状态是true了，但是程序依然在运行，所以interrupt并没有强制中断线程。
 *
 * @author yangjian
 * @date 2021-02-09 下午 04:46
 * @since 1.0.0
 */
public class InterruptThread1 implements Runnable {
    @Override
    public void run() {
        while (true) {
        }
    }
}
