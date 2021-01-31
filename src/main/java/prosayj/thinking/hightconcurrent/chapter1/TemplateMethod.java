package prosayj.thinking.hightconcurrent.chapter1;

/**
 * TemplateMethod
 *
 * @author yangjian
 * @date 2021-02-01 上午 12:55
 * @since 1.0.0
 */
public class TemplateMethod {
    public static void main(String[] args) {
        new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*" + message + "*");
            }
        }.print("Hello Thread");

        new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+" + message + "+");
            }
        }.print("Hello Thread");
    }

    public final void print(String message) {
        System.out.println("################");
        wrapPrint(message);
        System.out.println("################");
    }

    protected void wrapPrint(String message) {

    }
}
