package juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jing
 * @create 2020-03-22-17:12
 */
public class LastCp {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        myResource resource = new myResource(queue);
        new Thread(()->{
            try {
                resource.myCon();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"a").start();
        new Thread(()->{
                try {
                    resource.myPro();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        },"b").start();
        new Thread(()->{
            try {
                resource.myPro();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"c").start();
        TimeUnit.SECONDS.sleep(60);
        resource.setFlag();
    }
}
class myResource{
    private volatile Boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> queue = null;

    public myResource(BlockingQueue queue) {
        this.queue = queue;
    }
    public void myCon() throws Exception{
        String data = null;
        Boolean re;
        while (flag){
            TimeUnit.SECONDS.sleep(1);
            data = atomicInteger.incrementAndGet() + "";
            re = queue.offer(data, 3L, TimeUnit.SECONDS);
            if (re){
                System.out.println(Thread.currentThread().getName()+"插入成功");
            } else {
                System.out.println(Thread.currentThread().getName()+"插入失败");
            }
        }
        System.out.println("线程叫停");
    }

    public void myPro() throws Exception{
        String data = null;
        while (flag){
            data = queue.poll(3L, TimeUnit.SECONDS);
            TimeUnit.SECONDS.sleep(4);
            if (data != null && "".equalsIgnoreCase(data)){
                System.out.println(Thread.currentThread().getName()+"失败");
            } else {
                System.out.println(Thread.currentThread().getName()+data);
            }
        }
    }
    public void setFlag(){
        this.flag = false;
    }
}
class LastResource{
    private volatile Boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue;

    public LastResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    public void sheng() throws InterruptedException {
        String data;
        boolean re;
        while (flag){
            data = atomicInteger.incrementAndGet()+"";
            re = blockingQueue.offer(data, 3L, TimeUnit.SECONDS);
            if (re){
                System.out.println();
            } else {
                System.out.println();
            }
        }
        System.out.println();
    }
    public void xiao() throws InterruptedException {
        String data;
        while (flag){
            data = blockingQueue.poll(3L, TimeUnit.SECONDS);
            if ("".equals(data) && data==null){
                System.out.println();
            } else {
                System.out.println();
            }
        }
    }
}
