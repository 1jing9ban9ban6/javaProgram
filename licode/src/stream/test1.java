package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author jing
 * @create 2020-03-02-14:43
 */
public class test1 {
    @Test
    public void test1(){
        // Stream的初始化 是用来操作容器的
        IntStream stream = Arrays.stream(new int[5]);
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6);
        stream1.filter(integer -> {return integer>3;}).forEach(System.out::println);
//        List<Integer> collect = stream1.map(x -> {
//            return x * 2;
//        }).collect(Collectors.toList());
//        for (Integer d :collect) {
//            System.out.println(d);
//        }

    }
}
