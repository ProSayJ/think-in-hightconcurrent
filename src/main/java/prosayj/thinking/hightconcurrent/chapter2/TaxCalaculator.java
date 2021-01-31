package prosayj.thinking.hightconcurrent.chapter2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 税率计算
 *
 * @author yangjian
 * @date 2021-02-01 上午 01:06
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class TaxCalaculator {
    /**
     * 工资
     */
    private final double salary;
    /**
     * 奖金
     */
    private final double bonus;
    /**
     * 计算策略
     */
    private final CalculatorStrategy calculatorStrategy;

    /**
     * 计算税
     *
     * @return double
     */
    protected double calcTax() {
        return calculatorStrategy.calculate(salary, bonus);
    }

    /**
     * 计算税
     *
     * @return double
     */
    public double calculate() {
        return this.calcTax();
    }
}