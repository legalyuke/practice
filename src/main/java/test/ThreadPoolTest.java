package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyuke
 * @date 2021-06-01 21:14
 */
public class ThreadPoolTest {

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static ExecutorService cacheExecutorService = Executors.newCachedThreadPool();
    private static ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        executorService.execute(()->{
            Thread.currentThread().setName("Thread-"+ (int) (Math.random() * 1000));
            System.out.println("我是线程"+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

    }

}
