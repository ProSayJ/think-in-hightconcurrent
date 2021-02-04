package prosayj.thinking.hightconcurrent._02_threadrunways;

/**
 * 线程启动方式二
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:20
 */
public class RunnableDemo implements Runnable {
    public static void main(String[] args) {
        new Thread(new RunnableDemo()).start();
    }

    @Override
    public void run() {
        System.out.println("线程启动方式二:实现Runnable接口");
    }
}
