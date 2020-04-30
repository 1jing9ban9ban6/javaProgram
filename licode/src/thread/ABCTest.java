package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jing
 * @create 2020-03-17-13:32
 */
public class ABCTest {
    public static void main(String[] args) {
        resource resource = new resource();
            new Thread(()->{resource.print3();},"c").start();
            new Thread(()->{resource.print2();},"b").start();
            new Thread(()->{resource.print1();},"a").start();
    }
}
class resource{
    private Integer number = 1;
    private Lock lock = new ReentrantLock();
//    condition就是钥匙lock的钥匙
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    public void print1(){
        lock.lock();
        try {
//            判断
            while (number!=1){
                condition1.await();
            }
//            干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"A任务"+i);
            }
//            通知
            number++;
            condition2.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print2(){
        lock.lock();
        try {
//            判断
            while (number!=2){
                condition2.await();
            }
//            干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"B任务"+i);
            }
//            通知
            number++;
            condition3.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print3(){
        lock.lock();
        try {
//            判断
            while (number!=3){
                condition3.await();
            }
//            干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"C任务"+i);
            }
//            通知
            number=1;
            condition3.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
