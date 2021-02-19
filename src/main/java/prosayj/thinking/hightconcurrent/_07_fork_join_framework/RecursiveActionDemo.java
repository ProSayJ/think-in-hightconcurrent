package prosayj.thinking.hightconcurrent._07_fork_join_framework;

import prosayj.thinking.hightconcurrent._07_fork_join_framework.support.ForkJoinRecursiveAction;

import java.util.concurrent.ForkJoinPool;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-02-09 下午 06:15
 * @since 1.0.0
 */
public class RecursiveActionDemo {
    /**
     * 源文件夹
     */
    static String SOURCE_URL = "C:/source";
    static String TARGET_URL = "C:/target";

    public static void main(String[] args) {
        try {
            ForkJoinPool pool = new ForkJoinPool();
            ForkJoinRecursiveAction task = new ForkJoinRecursiveAction(SOURCE_URL,TARGET_URL);
            pool.execute(task);
            long start = System.currentTimeMillis();
            System.out.println("任务开始");
            task.join();
            long end = System.currentTimeMillis();
            System.out.println("任务结束，耗时：" + (end - start) / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
