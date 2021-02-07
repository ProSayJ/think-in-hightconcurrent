package prosayj.thinking.hightconcurrent._04_threadsynchronized;

import prosayj.thinking.hightconcurrent._04_threadsynchronized.support.MyThread;
import prosayj.thinking.hightconcurrent._04_threadsynchronized.support.Syn;
import prosayj.thinking.hightconcurrent._04_threadsynchronized.support.SynUseStaticMethods;

/**
 * 使用静态方法同步
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:48
 */
public class SynchronizeDemo4 {
    public static void main(String[] args) {
        Syn syn = new SynUseStaticMethods();
        new MyThread(syn, "t7").start();
        new MyThread(syn, "t8").start();
    }
}

