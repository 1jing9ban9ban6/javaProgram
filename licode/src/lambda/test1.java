package lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author jing
 * @create 2020-03-02-10:27
 * 作为接口的实例，没有接口就没有存在的意义
 * 而且要求接口只有一个函数 之生命了一个抽象方法就叫函数式接口
 *
 */
public class test1 {
    @Test
    public void test(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("重写的run方法");
            }
        };
    }
    @Test
    public void test1(){
        // 无参无返回值的lambda
        Runnable runnable = ()-> System.out.println("hh");
    }
    @Test
    public void test2(){
        // 有一个参数无返回值的lambda 不加string 是类型推断 如果参数只有一个 小括号也可以不写
        Consumer<String> consumer = s-> System.out.println("哈哈哈"+s);
        consumer.accept("hh");
    }
    @Test
    public void test3(){
        // 多个参数还有返回值
        Comparator<Integer> comparable = (i, j) ->{
            System.out.println(i);
            return i.compareTo(j);
        };
    }
    @Test
    public void test4(){
        // 多个参数还有返回值 但是方法体只有一个return时 还可以在简单
        Comparator<Integer> comparable = (i, j) -> i.compareTo(j);
    }
}
