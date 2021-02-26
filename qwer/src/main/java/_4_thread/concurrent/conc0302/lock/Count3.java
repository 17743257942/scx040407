
package _4_thread.concurrent.conc0302.lock;

/**
 * dead lock
 */
public class Count3 {

    private byte[] lock1 = new byte[1];
    private byte[] lock2 = new byte[1];

    public int num = 0;

    public void add() {
        synchronized (lock1) {
            try {
                Thread.sleep(1000);
                System.out.println("add1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                num += 1;
                System.out.println("add2");
            }
            System.out.println(Thread.currentThread().getName() + "_" + num);
        }
    }

    public void lockMethod() {
        synchronized (lock2) {
            try {
                Thread.sleep(1000);
                System.out.println("lockMethod3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                num += 1;
                System.out.println("lockMethod4");
            }
            System.out.println(Thread.currentThread().getName() + "_" + num);
        }
    }

    public static void main(String[] args) {
        Count3 demo = new Count3();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo.add();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                demo.lockMethod();
            }
        }).start();
    }

}
