package test;

import java.util.Arrays;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyuke
 * @date 2021-04-05 21:24
 */
public class ThreadTest {
    class Thread1 implements Runnable {

        @Override
        public void run() {
            System.out.println("我是线程1");
        }
    }

    private Lock lock = new ReentrantLock();

    void LockTest() {
        lock.lock();
        try {
            System.out.println("我获取到锁了");
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new ThreadTest().new Thread1()),
                thread3 = new Thread(new ThreadTest().new Thread1());
        thread1.setDaemon(true);
        thread1.start();
        thread1.interrupt();
        thread1.sleep(1000);
        new Thread((new ThreadTest().new Thread1())).start();
        new Thread(() -> {
            System.out.println("dfs");
        }).start();
        String s = "sfsdf";
        int[][] test = new int[10][10];
        Arrays.fill(test[0], 1);
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        int result = 0;
        Arrays.fill(c1, 0);
        Arrays.fill(c2, 0);
        for (char c : s.toCharArray()) {
            c1[c - 'a'] += 1;
        }
        for (char c : s.toCharArray()) {
            c2[c - 'a'] += 1;
        }
        for(int i = 0; i < c1.length; i++){
            if(c1[i] > c2[i]){
                result += c1[i]-c2[i];
            }
        }

    }
}
