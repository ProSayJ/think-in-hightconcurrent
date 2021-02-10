package prosayj.thinking.hightconcurrent._07_fork_join_framework.support;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * ForkJoinSemaphore
 *
 * @author yangjian
 * @date 2021-02-10 上午 10:30
 * @since 1.0.0
 */
public class ForkJoinSemaphore extends Thread{
    private final Semaphore semaphore;

    public ForkJoinSemaphore(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            //限制同一时间，访问特定资源的线程数量.
            semaphore.acquire();
            Thread.sleep(1000);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(Thread.currentThread().getName() + "-" + formatter.format(new Date()));
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
