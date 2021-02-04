package prosayj.thinking.hightconcurrent._02_threadrunways;

/**
 * 线程启动方式一
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:17
 */
public class ThreadDemo extends Thread {
    public static void main(String[] args) {
        new ThreadDemo().start();
    }

    @Override
    public void run() {
        System.out.println("线程启动方式一:继承Thread类");
    }
}
