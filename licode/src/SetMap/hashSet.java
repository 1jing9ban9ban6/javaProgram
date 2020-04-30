package SetMap;

import java.util.HashSet;

/**
 * @author jing
 * @create 2020-02-26-17:58
 */
public class hashSet {
    public static void main(String[] args) {
        // set 接口 没有新增 方法，都是coll的方法
        HashSet set = new HashSet();
        set.add(123);
        set.add("aaa");
        set.add("BBB");
        System.out.println(set); // 无序性不等于随机性 根据hash值决定在数组中的位置
    }
}
