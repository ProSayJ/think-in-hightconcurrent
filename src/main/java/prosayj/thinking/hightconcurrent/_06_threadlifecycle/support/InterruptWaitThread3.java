package prosayj.thinking.hightconcurrent._06_threadlifecycle.support;

/**
 * InterruptWaitThread3
 * 中断wait方法，这里需要注意的是，抛出异常后，中断状态变成false。
 *
 * @author yangjian
 * @date 2021-02-09 下午 05:11
 * @since 1.0.0
 */
public class InterruptWaitThread3 extends Thread {
    @Override
    public void run() {
        waitFun();
    }

    public synchronized void waitFun() {
        try {
            wait();
        } catch (InterruptedException e) {
            System.out.println("打扰我等待了");
        }
    }
}
