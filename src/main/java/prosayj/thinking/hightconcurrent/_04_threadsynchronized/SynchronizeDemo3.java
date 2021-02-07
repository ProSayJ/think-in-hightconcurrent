package prosayj.thinking.hightconcurrent._04_threadsynchronized;

import prosayj.thinking.hightconcurrent._04_threadsynchronized.support.MyThread;
import prosayj.thinking.hightconcurrent._04_threadsynchronized.support.Syn;
import prosayj.thinking.hightconcurrent._04_threadsynchronized.support.SynUseInstanceMethods;

/**
 * 使用实例方法同步
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:48
 */
public class SynchronizeDemo3 {

    public static void main(String[] args) {
        Syn syn = new SynUseInstanceMethods();
        new MyThread(syn, "t5").start();
        new MyThread(syn, "t6").start();
    }
}

