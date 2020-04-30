package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jing
 * @create 2020-04-25-11:10
 */
public class JZQ {
    public static void main(String[] args) {
        book book = new book();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                book.aVoid();
            }},"A").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                book.bVoid();
            }},"B").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                book.cVoid();
            }},"C").start();
    }
}
class book{
    private Integer num = 0;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void aVoid(){
        lock.lock();
        try {
            while (num!=0){
                c1.await();
            }
            System.out.println(Thread.currentThread().getName()+" "+num);
            num++;
            c2.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void bVoid(){
        lock.lock();
        try {
            while (num!=1){
                c2.await();
            }
            System.out.println(Thread.currentThread().getName()+" "+num);
            num++;
            c3.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void cVoid(){
        lock.lock();
        try {
            while (num!=2){
                c3.await();
            }
            System.out.println(Thread.currentThread().getName()+" "+num);
            num=0;
            c1.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
