package question4;

/**
 * @author jing
 * @create 2020-02-22-21:44
 */
public class threadOk {
    public static void main(String[] args) {
        ticket ticket = new ticket();
        Thread t1 = new Thread(ticket, "线程1");
        Thread t2 = new Thread(ticket, "线程2");
        Thread t3 = new Thread(ticket, "线程3");
        t1.start();
        t2.start();
        t3.start();

    }
}
class ticket implements Runnable{
    private int ticket = 100;
    Object object = new Object();
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            synchronized (object) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
