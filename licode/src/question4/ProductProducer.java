package question4;

/**
 * @author jing
 * @create 2020-02-23-21:40
 */
public class ProductProducer {
    public static void main(String[] args) {
        clerk clerk = new clerk();

        producer p = new producer(clerk);
        consumer c = new consumer(clerk);
        p.setName("生产者1号");
        c.setName("消费者1号");
        p.start();
        c.start();
    }
}

class clerk {
    private int product = 0;

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }
    public synchronized void con(){
        if (getProduct()>0){
            try {
                producer.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setProduct(getProduct()-1);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void pro(){
        if (getProduct()<20){
            try {
                consumer.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setProduct(getProduct()+1);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class consumer extends Thread {
    private clerk clerk;

    @Override
    public void run() {
        while (true) {
            clerk.con();
            System.out.println(Thread.currentThread().getName()+" "+"消费了1个，当前还有"+clerk.getProduct());
        }
    }

    public consumer(clerk clerk) {
        this.clerk = clerk;
    }
}

class producer extends Thread {
    private clerk clerk;

    @Override
    public void run() {
        while (true) {
            clerk.pro();
            System.out.println(Thread.currentThread().getName()+" "+"生产了1个，当前还有"+clerk.getProduct());
        }
    }

    public producer(clerk clerk) {
        this.clerk = clerk;
    }
}
