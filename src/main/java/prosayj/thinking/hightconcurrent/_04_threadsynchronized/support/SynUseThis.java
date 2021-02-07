package prosayj.thinking.hightconcurrent._04_threadsynchronized.support;

/**
 * TODO
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/5 0:10
 */
public class SynUseThis implements Syn {
    @Override
    public void myRun() {
        try {
            System.out.println(Thread.currentThread().getName() + "-myRun");
            synchronized (this) {
                Thread.sleep(3_000);
            }
            System.out.println(Thread.currentThread().getName() + "-myRun");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
