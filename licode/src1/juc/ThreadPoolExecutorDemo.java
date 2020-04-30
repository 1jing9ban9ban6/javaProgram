package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jing
 * @create 2020-03-22-21:38
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
//        获取线程池的三种方式 但其实本质是一种
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
    }
}
