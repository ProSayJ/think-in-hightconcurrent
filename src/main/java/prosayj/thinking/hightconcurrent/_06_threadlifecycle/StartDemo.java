package prosayj.thinking.hightconcurrent._06_threadlifecycle;

/**
 * 线程的生命周期：启动线程
 * <p>
 * 执行run的时候，run方法是main这个线程执行的，执行start的时候，run方法是startDemo线程执行的。
 *
 * @author yangjian
 * @date 2021-02-06 上午 10:58
 * @since 1.0.0
 */
public class StartDemo extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        StartDemo startDemo = new StartDemo();
        startDemo.setName("startDemo");
        startDemo.run();
        startDemo.start();
    }
}
