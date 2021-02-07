package prosayj.thinking.hightconcurrent._03_threadsafety.support;

import java.util.concurrent.Callable;

/**
 * 数字多线程操作类
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:32
 */
public class NumberOperatorCallable implements Callable<Integer> {
    private final NumberOperator numberOperator;

    public NumberOperatorCallable(NumberOperator numberOperator) {
        this.numberOperator = numberOperator;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 1000; i++) {
            numberOperator.increasing();
        }
        return numberOperator.getI();
    }
}
