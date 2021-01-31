package prosayj.thinking.hightconcurrent.chapter2;

/**
 * 简单计算策略实现
 *
 * @author yangjian
 * @date 2021-02-01 上午 01:06
 * @since 1.0.0
 */
public class SimpleCalculatorStrategy implements CalculatorStrategy {

    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.15;

    @Override
    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
