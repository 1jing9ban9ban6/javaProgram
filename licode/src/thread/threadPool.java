package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jing
 * @create 2020-03-18-10:54
 */
public class threadPool {
    public static void main(String[] args) {
//        固定数量的线程池
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        线程池只有一个线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        可扩展的线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
