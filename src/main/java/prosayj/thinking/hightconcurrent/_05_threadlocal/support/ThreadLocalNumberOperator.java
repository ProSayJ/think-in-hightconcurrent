package prosayj.thinking.hightconcurrent._05_threadlocal.support;

/**
 * @author yangjian
 * @date 2021-02-05 上午 11:18
 * @since 1.0.0
 */
public class ThreadLocalNumberOperator {
    private static final ThreadLocal<Integer> NUM = new ThreadLocal<>();

    public ThreadLocalNumberOperator increasing() {
        Integer integer = NUM.get();
        if (integer == null) {
            NUM.set(0);
        }
        NUM.set(NUM.get() + 1);
        return this;
    }

    public int getI() {
        return NUM.get();
    }
}
