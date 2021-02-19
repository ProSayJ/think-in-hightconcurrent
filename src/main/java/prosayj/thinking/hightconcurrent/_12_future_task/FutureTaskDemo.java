package prosayj.thinking.hightconcurrent._12_future_task;

import prosayj.thinking.hightconcurrent._12_future_task.support.ForkJoinFutureTask;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ForkJoinDemo
 * <p>
 * cancel(boolean mayInterruptIfRunning)：取消任务的执行失败，返回false，比如任务已经执行结束，或者已经被取消，或者不能被取消。如果执行成功了，返回ture。mayInterruptIfRunning的作用是是否中断，如果是true则中断，本质还是调用interrupt方法。
 * isCancelled：判断任务是否被取消，任务结束包括正常执行结束或异常结束，返回true。
 * isDone：是否执行结束，包括正常执行结束或异常结束。结束返回true。
 * get：获取返回值，没有得到返回值前一直阻塞。
 *
 * @author yangjian
 * @date 2021-02-10 上午 10:52
 * @since 1.0.0
 */
public class FutureTaskDemo {
    public static void main(String[] args) {
        FutureTask<Object> futureTask = new FutureTask<>(new ForkJoinFutureTask());

        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Thread.sleep(1_000);
            System.out.println("强制取消:" + futureTask.cancel(true));
            Thread.sleep(1_000);
            System.out.println("是否已经取消？:" + futureTask.isCancelled());
            System.out.println("是否完成？" + futureTask.isDone());
            System.out.println("获取结果：" + futureTask.get());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
        } catch (CancellationException e) {
            System.out.println("CancellationException");
        }
    }
}
