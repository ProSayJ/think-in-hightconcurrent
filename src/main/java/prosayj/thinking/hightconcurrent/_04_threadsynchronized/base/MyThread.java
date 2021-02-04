package prosayj.thinking.hightconcurrent._04_threadsynchronized.base;

/**
 * MyThread
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:59
 */
public class MyThread extends Thread {
    private final Syn syn;

    public MyThread(Syn syn, String threadName) {
        super(threadName);
        this.syn = syn;
    }

    @Override
    public void run() {
        syn.myRun();
    }
}
