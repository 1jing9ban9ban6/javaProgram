package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jing
 * @create 2020-03-17-20:25
 * 这个方法是用一个api保证前面执行了在执行最后一句话
 * 召集到了第0号龙珠
 * 召集到了第5号龙珠
 * 召集到了第4号龙珠
 * 召集到了第2号龙珠
 * 召集到了第3号龙珠
 * 召集到了第1号龙珠
 * 召集到了第6号龙珠
 * 召唤神龙
 */
public class cycTest {
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });
        for (int i = 0; i < 7; i++) {
            final Integer temp = i;
            new Thread(()->{
                System.out.println("召集到了第" + temp + "号龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
