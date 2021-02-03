package prosayj.thinking.hightconcurrent.chapter4;

import java.util.Optional;


/**
 * Thread 一些简单API
 *
 * @author yangjian
 * @date 2021-02-02 上午 07:20
 * @since 1.0.0
 */
public class ThreadSimpleAPI {
    public static void main(String[] args) {

        //获取线程名称、获取线程id、获取线程优先级
        test1();
        //测试线程的优先级
        test2();
    }

    /**
     * 测试线程优先级
     */
    private static void test2() {
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Optional.of(Thread.currentThread().getName() + "-Index" + i).ifPresent(System.out::println);
            }
        }, "t1") {{
            setPriority(Thread.MIN_PRIORITY);
        }}.start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Optional.of(Thread.currentThread().getName() + "-Index" + i).ifPresent(System.out::println);
            }
        }, "t2") {{
            setPriority(Thread.NORM_PRIORITY);
        }}.start();


        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Optional.of(Thread.currentThread().getName() + "-Index" + i).ifPresent(System.out::println);
            }
        }, "t3") {{
            setPriority(Thread.MAX_PRIORITY);
        }}.start();
    }

    /**
     * 获取线程名称、获取线程id、获取线程优先级
     */
    private static void test1() {
        Thread t = new Thread(() -> {
            Optional.of("Hello").ifPresent(System.out::println);
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        t.start();
        Optional.of("线程名称：" + t.getName()).ifPresent(System.out::println);
        Optional.of("线程id：" + t.getId()).ifPresent(System.out::println);
        Optional.of("优先级：" + t.getPriority()).ifPresent(System.out::println);
    }
}
