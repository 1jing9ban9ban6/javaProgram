package thread;

/**
 * @author jing
 * @create 2020-03-17-9:50
 * 线程6种状态 new runnable block waiting timed_waiting xiaohui
 * lam表达式 接口里面要有一个方法
 */
public class testThread {
    public static void main(String[] args) {
        ticket ticket = new ticket();
        new Thread(() -> {for (int i=0;i<200;i++) ticket.sale();},"A").start();
        new Thread(() -> {for (int i=0;i<200;i++) ticket.sale();},"B").start();
        lam lam = (Integer x, Integer y) -> {return x+y; };
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0;i<200;i++){
//                    ticket.sale();
//                }
//            }
//        }, "A").start();
    }
}
class ticket{
    private Integer ticket = 100;
    public void sale(){
        if (ticket>0){
            System.out.println(Thread.currentThread().getName()+":卖出了第"+ticket--+"张票，还有"+ticket);
        }
    }
}
@FunctionalInterface
interface lam{
    Integer add(Integer x, Integer y);
    public default void add1(Integer x, Integer y){
        System.out.println(x+y);
    }
    public static void add11(Integer x, Integer y){
        System.out.println(x+y);
    }
}
