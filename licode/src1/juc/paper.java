package juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jing
 * @create 2020-04-03-19:12
 */
public class paper {
    public static void main(String[] args) {
        Cas cas = new Cas();
        cas.myLock();
        cas.myUnlock();
    }
}
class Cas{
    private AtomicReference<Thread> reference = new AtomicReference();
    public void myLock(){
        Thread thread = Thread.currentThread();
        while (!reference.compareAndSet(null, thread)){}
    }
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        reference.compareAndSet(thread, null);
    }
}
class RW{
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock Lock = new ReentrantReadWriteLock();
    public void read(){
        Lock.readLock().lock();
        try {
            map.get("");
        } finally {
            Lock.readLock().unlock();
        }
    }
    public void write(){
        Lock.writeLock().lock();
        try {

        } finally {
            Lock.writeLock().unlock();
        }
    }
}
