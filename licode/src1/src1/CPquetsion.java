package src1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jing
 * @create 2020-03-22-16:54
 */
public class CPquetsion {
    public static void main(String[] args) {
        Car car = new Car();
        while (true){
            new Thread(()->{
                try {
                    car.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"a").start();
            new Thread(()->{
                try {
                    car.div();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"b").start();
        }

    }
}
class Car{
    private volatile Integer num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void add() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"  "+num);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public void div() throws InterruptedException {
        lock.lock();
        try {
            while (num == 0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"  "+num);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
