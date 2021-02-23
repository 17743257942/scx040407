package week04.concurrent.conc0301.op;

public class Join {
    
    public static void main(String[] args) {
        Object oo = new Object();
    
        MyThread thread1 = new MyThread("thread1 -- ");
        //oo = thread1;
        thread1.setOo(oo);
        thread1.start();
        
        synchronized (oo) {
            for (int i = 0; i < 20; i++) {
                if (i == 10) {
                    try {
//                        oo.wait(0);
                        thread1.join();
//                        run2(oo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " -- " + i);
            }
        }


    }

    public static void run2(Object oo) {
        synchronized (oo) {
            for (int i = 0; i < 50; i++) {
                System.out.println("run2 -- " + i);
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
        }
    }
    
}