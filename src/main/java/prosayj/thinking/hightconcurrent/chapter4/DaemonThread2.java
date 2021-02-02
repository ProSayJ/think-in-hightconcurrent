package prosayj.thinking.hightconcurrent.chapter4;


/**
 * TODO
 *
 * @author yangjian
 * @date 2021-02-02 上午 07:20
 * @since 1.0.0
 */
public class DaemonThread2 {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Do some thing for health check.");
                        Thread.sleep(1_000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            //innerThread.setDaemon(true);
            innerThread.start();

            try {
                Thread.sleep(1_000);
                System.out.println("T thread finish done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //t.setDaemon(true);
        t.start();


    }
}
