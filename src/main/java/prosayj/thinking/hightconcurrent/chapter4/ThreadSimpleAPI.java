package prosayj.thinking.hightconcurrent.chapter4;

import java.util.Optional;


/**
 * TODO
 *
 * @author yangjian
 * @date 2021-02-02 上午 07:20
 * @since 1.0.0
 */
public class ThreadSimpleAPI {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Optional.of("Hello").ifPresent(System.out::println);
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        t.start();
        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getId()).ifPresent(System.out::println);
        Optional.of(t.getPriority()).ifPresent(System.out::println);
    }
}
