package prosayj.thinking.hightconcurrent._05_threadlocal;

/**
 * TODO
 *
 * @author yangjian
 * @date 2021-02-05 上午 11:14
 * @since 1.0.0
 */
public class NotSafeDemo2 {
    private ThreadLocal<Integer> num = new ThreadLocal<>();

    public void add(int value) {
        try {
            if (null == num.get()) {
                num.set(0);
            }
            int temp = num.get();
            num.set(num.get() + value);
            Thread.sleep(100);
            System.out.println(value + "+" + temp + "=" + num.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NotSafeDemo2 synchronizeDemo = new NotSafeDemo2();
        AddThread3 addThread3 = new AddThread3(synchronizeDemo);
        AddThread4 addThread4 = new AddThread4(synchronizeDemo);
        addThread3.start();
        addThread4.start();
    }
}

class AddThread3 extends Thread {
    NotSafeDemo2 synchronizeDemo;

    public AddThread3(NotSafeDemo2 synchronizeDemo) {
        this.synchronizeDemo = synchronizeDemo;
    }

    @Override
    public void run() {
        synchronizeDemo.add(1);

    }
}

class AddThread4 extends Thread {
    NotSafeDemo2 synchronizeDemo;

    public AddThread4(NotSafeDemo2 synchronizeDemo) {
        this.synchronizeDemo = synchronizeDemo;
    }

    @Override
    public void run() {
        synchronizeDemo.add(2);
    }
}
