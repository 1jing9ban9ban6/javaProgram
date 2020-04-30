package juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author jing
 * @create 2020-04-26-11:59
 */
public class myLockTest {
    public static void main(String[] args) {
        myLock myLock = new myLock();
        new Thread(()->{
            myLock.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myLock.unlock();
        }, "A").start();

        new Thread(()->{
            myLock.lock();
            myLock.unlock();
        }, "B").start();
    }
}
class myLock{
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"上锁了");
        while (!atomicReference.compareAndSet(null, thread));
        System.out.println(Thread.currentThread().getName()+"上锁完成");
    }
    public void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"解锁了");
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName()+"解锁完成");
    }
}
