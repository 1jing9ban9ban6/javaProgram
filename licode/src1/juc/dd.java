package juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jing
 * @create 2020-03-22-19:14
 */
public class dd {
}
class resource{
    private volatile Boolean flag = true;
    private BlockingQueue<String> queue = null;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public void con() throws InterruptedException {
        while (true){
            String s = atomicInteger.incrementAndGet() + "";
            queue.offer(s, 2L, TimeUnit.SECONDS);
        }
    }
    public void pro() throws InterruptedException {
        while (true){
            queue.poll(2L, TimeUnit.SECONDS);
        }
    }
}
