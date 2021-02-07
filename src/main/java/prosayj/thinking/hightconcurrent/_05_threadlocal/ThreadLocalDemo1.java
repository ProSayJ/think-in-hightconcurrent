package prosayj.thinking.hightconcurrent._05_threadlocal;

import prosayj.thinking.hightconcurrent._05_threadlocal.support.ThreadLocalNumberOperator;

/**
 * ThreadLocal
 *
 * @author yangjian
 * @date 2021-02-05 下午 01:26
 * @since 1.0.0
 */
public class ThreadLocalDemo1 {
    public static void main(String[] args) {
        ThreadLocalNumberOperator t1 = new ThreadLocalNumberOperator();
        new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                t1.increasing().increasing();
            }
            System.out.println(t1.getI());
        }).start();
          System.out.println(t1.getI());
    }
}
