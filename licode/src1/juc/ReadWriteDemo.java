package juc;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jing
 * @create 2020-03-22-14:42
 */
public class ReadWriteDemo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(()->{
            try {
                demo.putMap("1",Thread.currentThread());
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"aa").start();
        new Thread(()->{
            try {
                demo.putMap("2",Thread.currentThread());
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"bb").start();
        new Thread(()->{
            try {
                demo.putMap("3",Thread.currentThread());
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"cc").start();
        new Thread(()->{
            try {
                demo.getMap("3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"dd").start();
        new Thread(()->{
            try {
                demo.getMap("3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"ee").start();
        new Thread(()->{
            try {
                demo.getMap("3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"ff").start();
    }




}
class Demo{
    private volatile HashMap<String, Object> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    public void putMap(String key, Object value) throws Exception {
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"开始写入");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"写入完成");
        } finally {
            lock.writeLock().unlock();
        }

    }
    public Object getMap(String key) throws InterruptedException {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始读取");
            Object o = map.get(key);
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName()+"读取完成");
            return o;
        } finally {
            lock.readLock().unlock();
        }
    }
}
