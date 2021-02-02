package prosayj.thinking.hightconcurrent.chapter3;

import java.util.Arrays;

/**
 * {@link Thread#toString()}
 *
 * @author yangjian
 * @date 2021-02-01 上午 07:22
 * @since 1.0.0
 */
public class CreateThread2 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        System.out.println("t1.getThreadGroup() = " + t1.getThreadGroup());

        //获取当前线程的名称
        Thread currentThread = Thread.currentThread();

        System.out.println("currentThread.getName() = " + currentThread.getName());

        ThreadGroup currentThreadThreadGroup = currentThread.getThreadGroup();

        System.out.println("currentThreadThreadGroup.getName() = " + currentThreadThreadGroup.getName());
        System.out.println("currentThreadThreadGroup.activeCount() = " + currentThreadThreadGroup.activeCount());
        System.out.println("currentThreadThreadGroup.activeCount() = " + currentThreadThreadGroup.activeCount());


        Thread[] threads = new Thread[currentThreadThreadGroup.activeCount()];
        //将此线程组及其子组中的每个活动线程复制到指定的数组中。
        currentThreadThreadGroup.enumerate(threads);

        System.out.println("==========");
        //Thread[线程名称,优先级,线程组名称]
        Arrays.asList(threads).forEach(System.out::println);
    }
}
