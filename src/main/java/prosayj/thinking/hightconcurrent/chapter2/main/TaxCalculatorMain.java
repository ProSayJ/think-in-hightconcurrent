package prosayj.thinking.hightconcurrent.chapter2.main;

import prosayj.thinking.hightconcurrent.chapter2.TaxCalaculator;

/**
 * TaxCalculatorMain
 *
 * @author yangjian
 * @date 2021-02-01 上午 01:06
 * @since 1.0.0
 */
public class TaxCalculatorMain {

    public static void main(String[] args) {
        System.out.println(new TaxCalaculator(10000d, 2000d, null) {
            @Override
            public double calcTax() {
                return getSalary() * 0.1 + getBonus() * 0.15;
            }
        }.calculate());

        System.out.println(new TaxCalaculator(10000d, 2000d, (s, b) -> s * 0.1 + b * 0.15).calculate());
    }
}
