package _4_thread.concurrent.conc0302.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ConditionDemo {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[20];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            // 当count等于数组的大小时，当前线程等待，直到notFull通知，再进行生产
            while (count == items.length) {
                notFull.await();
                System.out.println("put notFull.await()");
            }
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
            System.out.println("put notEmpty.signal()----count=" + count);
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            // 当count为0，进入等待，直到notEmpty通知，进行消费。
            while (count == 0) {
                notEmpty.await();
                System.out.println("take notEmpty.await()");
            }
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            System.out.println("take notFull.signal()----count=" + count);
            return x;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionDemo demo = new ConditionDemo();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    demo.put("put" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    demo.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

