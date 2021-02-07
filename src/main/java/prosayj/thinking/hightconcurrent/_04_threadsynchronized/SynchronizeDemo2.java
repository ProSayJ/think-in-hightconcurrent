package prosayj.thinking.hightconcurrent._04_threadsynchronized;

import prosayj.thinking.hightconcurrent._04_threadsynchronized.support.MyThread;
import prosayj.thinking.hightconcurrent._04_threadsynchronized.support.Syn;
import prosayj.thinking.hightconcurrent._04_threadsynchronized.support.SynUseThis;

/**
 * 有this的同步
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:47
 */
public class SynchronizeDemo2 {
    public static void main(String[] args) {
        Syn syn = new SynUseThis();
        new MyThread(syn, "t3").start();
        new MyThread(syn, "t4").start();
    }
}
