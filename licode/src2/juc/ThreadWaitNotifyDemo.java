package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jing
 * @create 2020-04-25-10:20
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        resources1 resources = new resources1();
        new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    resources.pro();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    resources.pro();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "D").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    resources.con();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    resources.con();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "C").start();
    }
}

class resources {
    private Integer num = 0;

    public synchronized void pro() throws InterruptedException {
        while (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + " " + num);
        this.notifyAll();
    }

    public synchronized void con() throws InterruptedException {
        while (num == 0) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + " " + num);
        this.notifyAll();
    }
}

class resources1 {
    private Integer num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void pro() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + " " + num);
            condition.signalAll();
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void con(){
        lock.lock();
        try {
            while (num == 0) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + " " + num);
            condition.signalAll();
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}