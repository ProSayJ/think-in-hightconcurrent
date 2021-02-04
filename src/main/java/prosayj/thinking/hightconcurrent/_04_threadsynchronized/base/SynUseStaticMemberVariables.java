package prosayj.thinking.hightconcurrent._04_threadsynchronized.base;

/**
 * synchronized：使用静态成员变量。锁当前类
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:53
 */
public class SynUseStaticMemberVariables implements Syn {
    static final String SYN = "";

    @Override
    public void myRun() {
        try {
            System.out.println(Thread.currentThread().getName() + "进来了");
            synchronized (SYN) {
                Thread.sleep(3_000);
            }
            System.out.println(Thread.currentThread().getName() + "出来了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
