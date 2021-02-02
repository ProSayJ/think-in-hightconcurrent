package prosayj.thinking.hightconcurrent.chapter3;

/**
 * @author yangjian
 * @date 2021-02-01 上午 07:22
 * @since 1.0.0
 */
public class CreateThread3 {

    private final int i = 0;

    private final byte[] bytes = new byte[1024];

    private static int counter = 0;

    /**
     * JVM will create a thread named "main"
     */
    public static void main(String[] args) {
        //create a JVM stack
        try {
            add(0);
        } catch (Error e) {
            e.printStackTrace();
            System.out.println(counter);
        }
    }

    private static void add(int i) {
        ++counter;
        add(i + 1);
    }
}


//StackOverflowError
//21456