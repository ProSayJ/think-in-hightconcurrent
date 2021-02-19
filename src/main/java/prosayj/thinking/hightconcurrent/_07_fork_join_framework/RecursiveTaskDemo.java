package prosayj.thinking.hightconcurrent._07_fork_join_framework;

import prosayj.thinking.hightconcurrent._07_fork_join_framework.support.ForkJoinRecursiveTask;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * 两次结果是一样的。
 * <p>
 * 创建ForkJoinPool对象。
 * 创建继承RecursiveTask的类，实现compute方法，这里主要是计算以及拆分任务、合并结果。
 * pool.invoke方法调用。
 *
 * @author yangjian
 * @date 2021-02-09 下午 05:41
 * @since 1.0.0
 */
public class RecursiveTaskDemo {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int[] randomArr = getRandomArr(1000);
        ForkJoinRecursiveTask task = new ForkJoinRecursiveTask(randomArr, 0, randomArr.length - 1);
        System.out.println("总数1=" + pool.invoke(task));
        System.out.println("总数2=" + Arrays.stream(randomArr).parallel().sum());
    }

    public static int[] getRandomArr(int num) {
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
        }
        return arr;
    }
}
