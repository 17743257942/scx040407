package _4_thread.test;

import java.util.concurrent.*;

/**
 * （必做）思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这
 * 个方法的返回值后，退出主线程？
 */
public class Demo {

    public static int getR() {
        return 123;
    }

    public static void main(String[] args) throws Exception {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return getR();
            }
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
