package prosayj.thinking.hightconcurrent.chapter1;

/**
 * TryConcurrency-线程同步
 *
 * @author yangjian
 * @date 2021-02-01 上午 12:59
 * @since 1.0.0
 */
public class TryConcurrency {

    public static void main(String[] args) {
        new Thread("READ-Thread") {
            @Override
            public void run() {
                println(Thread.currentThread().getName());
                readFromDataBase();
            }
        }.start();

        new Thread("WRITE-Thread") {
            @Override
            public void run() {
                writeDataToFile();
            }
        }.start();
    }

    /**
     * 读线程
     */
    private static void readFromDataBase() {
        //read data from database and handle it.
        try {
            println("Begin read data from db.");
            Thread.sleep(1000 * 5L);
            println("Read data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        println("The data handle finish and successfully.");
    }

    /**
     * 写线程
     */
    private static void writeDataToFile() {
        try {
            println("Begin write data to file.");
            Thread.sleep(2000 * 10L);
            println("Write data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        println("The data handle finish and successfully.");
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
