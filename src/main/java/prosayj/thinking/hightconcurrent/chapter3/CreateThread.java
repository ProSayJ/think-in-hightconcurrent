package prosayj.thinking.hightconcurrent.chapter3;

/**
 * 创建线程的几种方式：
 *
 * @author yangjian
 * @date 2021-02-01 上午 07:22
 * @since 1.0.0
 */
public class CreateThread {
    public static void main(String[] args) {
        //新建一个 Thread 类
        Thread t1 = new Thread();
        //新建一个 Thread 类 实现 Runnable 接口
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("=====t2==run=====");
            }
        };
        t1.start();
        t2.start();
        System.out.println("t1.getName() = " + t1.getName());
        System.out.println("t2.getName() = " + t2.getName());

        Thread t3 = new Thread("MyName");
        Thread t4 = new Thread(() -> {
            System.out.println("Runnable...");
        });

        System.out.println("t3.getName() = " + t3.getName());
        System.out.println("t4.getName() = " + t4.getName());

        Thread t5 = new Thread(
                () -> System.out.println("Runnable..." + Thread.currentThread().getName()),
                "RunnableThread");
        t5.start();
        System.out.println("t5.getName() = " + t5.getName());
    }
}
