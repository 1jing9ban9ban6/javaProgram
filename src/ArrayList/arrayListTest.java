package ArrayList;

import java.util.ArrayList;

/**
 * 测试ArrayList的数据类型，它可以装任意个具体数据。长度可变
 * <要装入数据的类型>
 * 重要功能； add 添加 get 取索引上的元素 remove 删除
 */

public class arrayListTest {
    public static void main(String[] args) {
        // 创建一个用来装整数的ArrayList对象
        ArrayList<Integer> inter = new ArrayList<>();
        // 想ArrayList添加数据
        inter.add(1);
        inter.add(3);
        inter.add(5);
        // 想ArrayList取数据
        int a = inter.get(0);
        System.out.println(a);
        // 将arraylist 的数据安角标顺序全部打出来
        for (int i = 0; i < inter.size(); i++){
            System.out.println(inter.get(i));
        }
        // 将ArrayList 中的数据移除
        inter.remove(1);
        // 更改ArrayList 中的值
        inter.set(0,10);
        System.out.println(inter.get(0));
    }
}
