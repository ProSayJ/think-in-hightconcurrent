package prosayj.thinking.hightconcurrent.chapter3;

/**
 * @author yangjian
 * @date 2021-02-01 上午 07:22
 * @since 1.0.0
 */
public class CreateThread5 {

    private static int counter = 1;

    public static void main(String[] args) {

        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                counter++;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            add(1);
                        } catch (Error e) {
//                            System.out.println(counter);
                        }
                    }

                    private void add(int i) {
                        add(i + 1);
                    }
                }).start();
            }
        } catch (Error e) {
            counter++;
        }
        System.out.println("Total created thread nums=>" + counter);
    }
}
