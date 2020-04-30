package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jing
 * @create 2020-03-17-12:00
 */
public class lockTest {
    public static void main(String[] args) {
        apple apple = new apple();
        new Thread(()->{
            for (int i=0;i<10;i++){
                try {
                    apple.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者1").start();
        new Thread(()->{
            for (int i=0;i<10;i++){
                try {
                    apple.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者2").start();
        new Thread(()->{
            for (int i=0;i<10;i++){
                try {
                    apple.div();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者1").start();
        new Thread(()->{
            for (int i=0;i<10;i++){
                try {
                    apple.div();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者2").start();
    }
}
class apple{
    private Integer number = 0;
//    创建可充用锁
    private Lock lock = new ReentrantLock();
//    新版的wait
    private Condition condition = lock.newCondition();
    public void add() throws InterruptedException {
        lock.lock();
        try {
            //        判断
            while (number!=0){
                condition.await();
            }
            //        干活
            number++;
            System.out.println(Thread.currentThread().getName()+": "+number);
            //        通知
            condition.signalAll();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void div() throws InterruptedException {
        lock.lock();
        try {
            //        判断
            while (number==0){
                condition.await();
            }
            //        干活
            number--;
            System.out.println(Thread.currentThread().getName()+": "+number);
            //       通知
            condition.signalAll();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

