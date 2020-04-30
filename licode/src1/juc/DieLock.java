package juc;

/**
 * @author jing
 * @create 2020-03-23-10:14
 */
public class DieLock{
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new source(lockA, lockB),"AAA").start();
        new Thread(new source(lockB, lockA),"bbb").start();
    }
}
class source implements Runnable{
    private String lock1;
    private String lock2;

    public source(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName()+lock1+" 尝试获取"+lock2);
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+lock2+" 尝试获取"+lock1);
            }
        }
    }
}
class resource1 implements Runnable{
    private String lock1;
    private String lock2;
    public resource1(String lock1, String lock2){
        this.lock1=lock1;
        this.lock2=lock2;
    }
    @Override
    public void run() {
        synchronized (lock1){
            System.out.println("");
            synchronized (lock2){
                System.out.println("");
            }
        }
    }
}
