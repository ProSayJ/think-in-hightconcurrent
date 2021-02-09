package prosayj.thinking.hightconcurrent._07_fork_join_framework.support;


import java.util.concurrent.RecursiveTask;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-02-09 下午 05:44
 * @since 1.0.0
 */
public class ForkJoinRecursiveTask extends RecursiveTask<Integer> {
    private static final int MAX = 50;
    private final int[] arr;
    private final int start;
    private final int end;

    public ForkJoinRecursiveTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) < MAX) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            int mid = (end + start) / 2;
            ForkJoinRecursiveTask left = new ForkJoinRecursiveTask(arr, start, mid);
            ForkJoinRecursiveTask right = new ForkJoinRecursiveTask(arr, mid + 1, end);
            invokeAll(left, right);
            return left.join() + right.join();
        }
    }

}
