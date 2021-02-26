package _3_netty.nio.timeServer2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TimeServerHandlerExecutePool {

    private Executor executor ;
    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        executor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                maxPoolSize,
                120L,
                SECONDS,
                new ArrayBlockingQueue<>(queueSize));
    }

    public void execute(Runnable task) {
        executor.execute(task);
    }
}
