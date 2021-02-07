package prosayj.thinking.hightconcurrent._06_threadlifecycle.support;

/**
 * TODO
 *
 * @author yangjian201127@credithc.com
 * @date 2021-02-06 下午 01:57
 * @since 1.0.0
 */
public class PersonThread extends Thread {
    private final TV tv;

    public PersonThread(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        watchTv();
    }

    private synchronized void watchTv() {
        while (tv.getMovies() == null) {
            try {
                System.out.println(Thread.currentThread().getName() + "-" + "骗人，还是广告");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "-" + "愉快的追剧");
        notifyAll();
    }
}
