package question4;

/**
 * @author jing
 * @create 2020-02-23-21:09
 */
public class ThreadNum {
    public static void main(String[] args) {
        num num = new num();
        Thread t1 = new Thread(num, "线程1");
        Thread t2 = new Thread(num, "线程2");

        t1.start();
        t2.start();

    }
}
class num implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                if (number<=100){
                    this.notify();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" "+number);
                    number++;
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
