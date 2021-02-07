package prosayj.thinking.hightconcurrent._06_threadlifecycle;

import prosayj.thinking.hightconcurrent._06_threadlifecycle.support.JoinThread;

/**
 * 线程的生命周期：Join线程
 * <p>
 * 线程t2执行的时候，调用线程t1的join，线程t1不休眠，线程t2休眠了5秒，
 * 从结果看出来，线程t1执行完后，线程t2才执行完。
 *
 * @author yangjian
 * @date 2021-02-06 上午 11:04
 * @since 1.0.0
 */
public class JoinDemo {
    public static void main(String[] args) {
        JoinThread t1 = new JoinThread(null, "t1");
        JoinThread t2 = new JoinThread(t1, "t2");
        t1.start();
        t2.start();
    }
}
