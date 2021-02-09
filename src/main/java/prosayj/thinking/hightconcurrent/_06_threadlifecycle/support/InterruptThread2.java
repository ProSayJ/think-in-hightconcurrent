package prosayj.thinking.hightconcurrent._06_threadlifecycle.support;

import static java.lang.Thread.interrupted;

/**
 * 通过判断中断状态，来处理我们自己的业务逻辑，这样的设计，给程序带来了极大的利灵活性。
 *
 * @author yangjian201127@credithc.com
 * @date 2021-02-09 下午 04:46
 * @since 1.0.0
 */
public class InterruptThread2 implements Runnable {
    @Override
    public void run() {
        //判断当前线程是否中断，并清除中断标志
        while (!interrupted()) {
        }
        System.out.println("已中断");
    }
}
