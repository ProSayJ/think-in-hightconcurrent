package prosayj.thinking.hightconcurrent._04_threadsynchronized;

import prosayj.thinking.hightconcurrent._04_threadsynchronized.base.MyThread;
import prosayj.thinking.hightconcurrent._04_threadsynchronized.base.Syn;
import prosayj.thinking.hightconcurrent._04_threadsynchronized.base.SynUseStaticMemberVariables;

/**
 * 无this的同步
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:44
 */
public class SynchronizeDemo1 {
    /**
     * 等 t1 把代码块的执行完，释放了syn的锁，t2才开始执行。
     */
    public static void main(String[] args) {
        Syn syn = new SynUseStaticMemberVariables();
        new MyThread(syn, "t1").start();
        new MyThread(syn, "t2").start();
    }
}
