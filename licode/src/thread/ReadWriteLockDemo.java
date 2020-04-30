package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jing
 * @create 2020-03-17-21:24
 * 读写锁   一起读 但是只有一个人来写
 * Thread-0准备写入
 * Thread-0写入完成
 * Thread-1准备写入
 * Thread-1写入完成
 * Thread-2准备写入
 * Thread-2写入完成
 * Thread-4准备写入
 * Thread-4写入完成
 * Thread-3准备写入
 * Thread-3写入完成
 * Thread-5准备读取
 * Thread-5读取完成Thread-0
 * Thread-6准备读取
 * Thread-6读取完成Thread-1
 * Thread-9准备读取
 * Thread-8准备读取
 * Thread-7准备读取
 * Thread-9读取完成Thread-4
 * Thread-7读取完成Thread-2
 * Thread-8读取完成Thread-3
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        memory memory = new memory();
        for (int i = 0; i < 5; i++) {
            final Integer temp = i;
            new Thread(()->{
                memory.put(temp);
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            final Integer temp = i;
            new Thread(()->{
                memory.get(temp);
            }).start();
        }
    }
}
class memory{
    private Map<Integer, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(Integer i){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"准备写入");
            map.put(i,Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName()+"写入完成");
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }
    public void get(Integer i){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"准备读取");
            Object o = map.get(i);
            System.out.println(Thread.currentThread().getName()+"读取完成"+o);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}
