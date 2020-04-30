package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author jing
 * @create 2020-03-02-11:06
 */
public class test2 {
    @Test
    public void test(){
        happy(50, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println(aDouble+50);
            }
        });
        happy(20, (aDouble)->System.out.println("哈哈"));
    }
    public void happy(double d, Consumer<Double> c){
        c.accept(d);
    }

    @Test
    public void test3(){
        List<String> strings = Arrays.asList("黑安之魂","只狼","黑暗之女2","黑黑的");
        List<String> s = filterString(strings, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("黑");
            }
        });
//        System.out.println(s);
        List<String> 黑 = filterString(strings, s1 -> s1.contains("黑"));
        System.out.println(黑);
    }
    public List<String> filterString (List<String> list, Predicate<String> pre){
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s:list){
            if (pre.test(s)){
                arrayList.add(s);
            }
        }
        return arrayList;
    }

}
