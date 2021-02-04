package prosayj.thinking.hightconcurrent._03_threadsafety.base;

/**
 * 数字操作类
 *
 * @author ProSayJ
 * @version V1.0.0
 * @date 2021/2/4 23:32
 */
public class NumberOperator {
    private int i;

    public void increasing() {
        i++;
    }

    public int getI() {
        return i;
    }
}
