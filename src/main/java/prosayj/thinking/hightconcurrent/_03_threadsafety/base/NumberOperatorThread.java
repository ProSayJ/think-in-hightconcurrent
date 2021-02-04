package prosayj.thinking.hightconcurrent._03_threadsafety.base;

/**
 * 数字多线程操作类
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:32
 */
public class NumberOperatorThread extends Thread {
    private final NumberOperator numberOperator;

    public NumberOperatorThread(NumberOperator numberOperator) {
        this.numberOperator = numberOperator;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            numberOperator.increasing();
        }
    }
}
