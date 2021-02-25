package week04.concurrent.conc0302.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(getName() + "被中断了");
                }
                System.out.println(getName() + "继续执行");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000L);
        t2.start();
        Thread.sleep(1000L);
        System.out.println("main t1.interrupt()");
        t1.interrupt(); // also a way to unpark
        Thread.sleep(1000L);
        System.out.println("main LockSupport.unpark(t2)");
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}


