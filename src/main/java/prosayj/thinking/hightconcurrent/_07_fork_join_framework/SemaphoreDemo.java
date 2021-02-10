package prosayj.thinking.hightconcurrent._07_fork_join_framework;

import prosayj.thinking.hightconcurrent._07_fork_join_framework.support.ForkJoinSemaphore;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreDemo
 * <p>
 * 信号量，限制同一时间，访问特定资源的线程数量，以保证合理的使用特定资源
 *
 * @author yangjian
 * @date 2021-02-10 上午 10:31
 * @since 1.0.0
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 8; i++) {
            //每次执行都是2个
            new ForkJoinSemaphore("t" + i, semaphore).start();
        }
    }
}
