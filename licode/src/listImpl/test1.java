package listImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jing
 * @create 2020-02-26-17:37
 */
public class test1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add(5);
        list.add("BB");
        list.add(1,"CC"); // 在某个位置插入 一个个后移动
        List<Integer> integers = Arrays.asList(123, 456);
        list.addAll(3,integers);
        System.out.println(list);
        System.out.println(list.get(3));
        System.out.println(list.indexOf("BB")); //首次出现的索引位置
        boolean bb = list.remove("BB");
        List list1 = list.subList(1, 3); //返回一个子串 本身的list不会有影响
    }
}
