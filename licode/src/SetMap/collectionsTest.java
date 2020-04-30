package SetMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author jing
 * @create 2020-02-27-17:07
 */
public class collectionsTest {
    public static void main(String[] args) {
        // 操作  set map list的类
//        Collections.reverse(); 反转 list
//        Collections.shuffle(); 随机输出 list
//        Collections.sort(); 排序 list
//        Collections.swap(); 交换 1 2 位置的元素 list
//        Collections.max() 找最大
//        Collections.frequency() 招聘率
//        Collections.copy(); 把src 复制到dest
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(2345);
        list.add(645);
        list.add(76);
        ArrayList dest = (ArrayList)Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);
    }
}
