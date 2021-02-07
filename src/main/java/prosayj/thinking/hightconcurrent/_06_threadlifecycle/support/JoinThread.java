package prosayj.thinking.hightconcurrent._06_threadlifecycle.support;

/**
 * JoinThread
 *
 * @author yangjian
 * @date 2021-02-06 上午 11:06
 * @since 1.0.0
 */
public class JoinThread extends Thread {
    private final Thread otherThread;


    public JoinThread(Thread otherThread, String thisThreadName) {
        super(thisThreadName);
        this.otherThread = otherThread;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "    start");
            if (otherThread != null) {
                System.out.println(otherThread.getName() + "    加入到线程：" + Thread.currentThread().getName());
                otherThread.join();
            }
            Thread.sleep(5_000);
            System.out.println(Thread.currentThread().getName() + "    end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
