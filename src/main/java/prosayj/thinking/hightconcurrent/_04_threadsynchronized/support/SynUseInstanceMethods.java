package prosayj.thinking.hightconcurrent._04_threadsynchronized.support;

/**
 * synchronized：使用实例方法。锁当前实例对象
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/5 0:15
 */
public class SynUseInstanceMethods implements Syn {
    @Override
    public synchronized void myRun() {
        System.out.println(Thread.currentThread().getName() + "进来了");
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "出来了");

    }
}
