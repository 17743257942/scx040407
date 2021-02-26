package _4_thread.concurrent.conc0301.op;

import java.util.concurrent.atomic.AtomicBoolean;

public class Join {

    public static void main(String[] args) {
        Object oo = new Object();

        MyThread thread1 = new MyThread("thread1 -- ");
//        oo = thread1;
        oo = new AtomicBoolean(false);
        thread1.setOo(oo);
        thread1.start();

        synchronized (oo) {
            for (int i = 0; i < 20; i++) {
                if (i == 10) {
                    try {
                        oo.wait(0); // oo/thread1 wait
                        System.out.println("i am wake up");
                        thread1.join(); //do nothing but wait() notifyAll(), so lock(oo/thread1) alive
                        System.out.println("thread join over");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " -- " + i);
            }
        }


    }


}

class MyThread extends Thread {

    private String name;
    private Object oo;

    public void setOo(Object oo) {
        this.oo = oo;
    }

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (oo) {
            for (int i = 0; i < 50; i++) {
                System.out.println(name + i);
            }
            oo.notifyAll();
        }
    }

}