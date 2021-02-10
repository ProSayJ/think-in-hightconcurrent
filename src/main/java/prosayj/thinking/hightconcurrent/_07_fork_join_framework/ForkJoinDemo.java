package prosayj.thinking.hightconcurrent._07_fork_join_framework;

import prosayj.thinking.hightconcurrent._07_fork_join_framework.support.ForkJoinFutureTask;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ForkJoinDemo
 *
 * @author yangjian
 * @date 2021-02-10 上午 10:52
 * @since 1.0.0
 */
public class ForkJoinDemo {
    public static void main(String[] args) {
        FutureTask<Object> futureTask = new FutureTask<>(new ForkJoinFutureTask());

        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Thread.sleep(1_000);
            System.out.println("cancel:" + futureTask.cancel(true));
            Thread.sleep(1_000);
            System.out.println("isCancelled:" + futureTask.isCancelled());
            System.out.println("isDone:" + futureTask.isDone());
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
        } catch (CancellationException e) {
            System.out.println("CancellationException");
        }
    }
}
