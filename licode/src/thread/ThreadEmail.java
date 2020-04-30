package thread;

/**
 * @author jing
 * @create 2020-03-17-10:51
 */
public class ThreadEmail {
    public static void main(String[] args) {
        air air = new air();
        new Thread(()->{for (int i = 0; i<10; i++) {
            try {
                air.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"生产者1").start();
        new Thread(()->{for (int i = 0; i<10; i++) {
            try {
                air.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"生产者2").start();
        new Thread(() -> {
            for (int i = 0; i<10; i++){
                try {
                    air.div();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者1").start();
        new Thread(() -> {
            for (int i = 0; i<10; i++){
                try {
                    air.div();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者2").start();
    }
}
class air{
    private Integer num = 0;
    public synchronized void add() throws InterruptedException {
//        判断
        while (num!=0){
            this.wait();
        }
//        干活
        num++;
        System.out.println(Thread.currentThread().getName()+": "+num);
//        通知
        this.notifyAll();
    }
    public synchronized void div() throws InterruptedException {
//        判断
        while (num==0){
            this.wait();
        }
//        干活
        num--;
        System.out.println(Thread.currentThread().getName()+": "+num);
//        通知
        this.notifyAll();
    }
}
