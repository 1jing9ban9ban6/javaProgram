package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author jing
 * @create 2020-03-17-20:54
 *
 * 0离开了教室
 * 5离开了教室
 * 1离开了教室
 * 2离开了教室
 * 3离开了教室
 * 4离开了教室
 * 班长锁门
 */
public class countDown {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            final Integer temp = i;
            new Thread(()->{
                System.out.println(temp+"离开了教室");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("班长锁门");
    }
}
