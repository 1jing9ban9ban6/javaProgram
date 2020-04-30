package question4;

/**
 * @author jing
 * @create 2020-02-22-13:47
 * 继承thread类 重写run方法 创建子类对象 调用start方法。
 *
 *
 * start() 启动当前线程
 * run() 需要线程执行的代码需要重写
 * currentThread() 获取当前的线程
 * getName() 获取线程的名字
 * setName() 设置线程的名字
 * yield() 释放执行权 就绪状态
 * stop() 死亡
 * sleep() join() 到阻塞状态 wait() 同步锁 suspend挂起
 *                          notify       resume 结束挂起
 */
public class thread {
    public static void main(String[] args) {
//        myThread myThread = new myThread();
//        myThread.start();//启动当前线程；调用当前线程的run方法
//        new myThread().start();
//        for(int i=0;i<100;i++){
//            if ((i%2)==0){
//                System.out.println(Thread.currentThread().getName()+" "+i);
//            }
//        }
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                // 重写 run方法  此线程执行的功能
//                for (int i = 0; i < 100; i++) {
//                    if ((i % 2) == 0) {
//                        System.out.println(Thread.currentThread().getName() + " " + i);
//                    }
//                    try {
//                        this.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        thread.start();
//        thread.setPriority(Thread.MAX_PRIORITY);
        MThread mThread = new MThread();
        Thread thread = new Thread(mThread,"线程1");
        thread.start();
    }
}
class myThread extends Thread{
    @Override
    public void run() {
        // 重写 run方法  此线程执行的功能
        for(int i=0;i<100;i++){
            if ((i%2)==0){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }
        hah();
    }
    public void hah(){
        System.out.println("jj");
    }
}
class MThread implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if ((i%2)==0){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }
    }
}
