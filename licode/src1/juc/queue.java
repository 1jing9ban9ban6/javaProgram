package juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author jing
 * @create 2020-04-03-21:42
 */
public class queue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                queue.put(1);
                queue.put(2);
                queue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"a").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"b").start();
    }
}

