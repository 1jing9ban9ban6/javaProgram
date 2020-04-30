package juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author jing
 * @create 2020-03-22-11:47
 */
public class AtomicDemo {
    private volatile AtomicReference<Thread> reference = new AtomicReference<>();
    public void myLock(){
        Thread thread = Thread.currentThread();
        while (!reference.compareAndSet(null, thread)){ }
    }
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        reference.compareAndSet(thread,null);
    }

    public static void main(String[] args) {
//        Runtime.getRuntime().availableProcessors() 查看cpu 核心数
        AtomicDemo atomicDemo = new AtomicDemo();
        new Thread(()->{
            atomicDemo.myLock();
            System.out.println(Thread.currentThread().getName()+"进来了");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicDemo.myUnlock();
            System.out.println(Thread.currentThread().getName()+"出去了");
        },"AA").start();
        new Thread(()->{
            atomicDemo.myLock();
            System.out.println(Thread.currentThread().getName()+"进来了");
            atomicDemo.myUnlock();
            System.out.println(Thread.currentThread().getName()+"出去了");
        },"BB").start();
    }
}
