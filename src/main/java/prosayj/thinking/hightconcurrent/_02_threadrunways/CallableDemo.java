package prosayj.thinking.hightconcurrent._02_threadrunways;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程启动方式三
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:21
 */
public class CallableDemo implements Callable<String> {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CallableDemo());
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String call() throws Exception {
        return "线程启动方式三:实现 Callable 接口";
    }
}