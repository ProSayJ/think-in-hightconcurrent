package prosayj.thinking.hightconcurrent._06_threadlifecycle;

import lombok.SneakyThrows;
import prosayj.thinking.hightconcurrent._06_threadlifecycle.support.InterruptThread1;
import prosayj.thinking.hightconcurrent._06_threadlifecycle.support.InterruptThread2;
import prosayj.thinking.hightconcurrent._06_threadlifecycle.support.InterruptWaitThread3;

import static java.lang.Thread.sleep;

/**
 * InterruptDemo
 *
 * @author yangjian201127@credithc.com
 * @date 2021-02-09 下午 04:40
 * @since 1.0.0
 * <p>
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        doAnalysisThreadStatus(new Thread(new InterruptThread2(), "t2"));
        doAnalysisThreadStatus(new Thread(new InterruptThread1(), "t1"));

        InterruptWaitThread3 thread = new InterruptWaitThread3();
        thread.start();
        System.out.println(thread.getState());
        sleep(1000);
        thread.interrupt();
        sleep(1000);
        System.out.println(thread.getState());
        System.out.println(thread.isInterrupted());
        sleep(1000);
        System.out.println(thread.getState());

    }

    /**
     * 分析线程状态
     *
     * @param thread thread
     * @throws InterruptedException InterruptedException
     */
    static void doAnalysisThreadStatus(Thread thread) throws InterruptedException {
        thread.start();
        System.out.println(thread.getName() + "(1)线程状态：===>" + thread.getState());
        sleep(1_000);
        //thread设置中断标记位
        thread.interrupt();
        System.out.println(thread.getName() + "(2)线程状态：===>" + thread.getState());
        //isInterrupted:判断当前线程是否中断，并清除中断标志
        System.out.println(thread.getName() + "(3)是否被中断：===>" + thread.isInterrupted());
        System.out.println(thread.getName() + "(4)线程状态：===>" + thread.getState());
    }
}
