package prosayj.thinking.hightconcurrent.chapter2;

/**
 * 计算策略
 *
 * @author yangjian
 * @date 2021-02-01 上午 01:06
 * @since 1.0.0
 */
@FunctionalInterface
public interface CalculatorStrategy {

    double calculate(double salary, double bonus);
}
