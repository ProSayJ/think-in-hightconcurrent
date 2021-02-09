package prosayj.thinking.hightconcurrent._06_threadlifecycle;

import prosayj.thinking.hightconcurrent._06_threadlifecycle.support.Movies;
import prosayj.thinking.hightconcurrent._06_threadlifecycle.support.TV;
import prosayj.thinking.hightconcurrent._06_threadlifecycle.support.PersonThread;

/**
 * 线程的生命周期：wait线程
 * <p>
 * 大部分人喜欢看连续剧，但是不看广告（没钱买VIP），于是就让别人提醒她广告结束了没有，如果结束了，就提醒她。
 *
 * @author yangjian
 * @date 2021-02-06 下午 01:50
 * @since 1.0.0
 */
public class WaitDemo {
    public static void main(String[] args) throws InterruptedException {
        TV tv = new TV();
        PersonThread person1 = new PersonThread(tv);
        new PersonThread(tv).start();
        person1.start();
        Thread.sleep(5_000);
        tv.setMovies(new Movies());
        Thread.sleep(3_000);
    }
}
