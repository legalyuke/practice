package test;

import java.util.concurrent.*;

import static java.lang.System.out;

/**
 * @author liyuke
 * @date 2021-05-20 21:51
 */
public class ThreadTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            return "success";
        });
        executorService.submit(futureTask);
        TimeUnit.SECONDS.sleep(1);
        if (futureTask.isDone()) {
            out.println(futureTask.get());
        }
        executorService.shutdown();
        char c = 0;

    }
}
