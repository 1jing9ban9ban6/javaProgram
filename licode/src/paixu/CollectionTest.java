package paixu;

import org.junit.Test;

import java.util.*;

/**
 * @author jing
 * @create 2020-02-25-20:18
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("aa");
        coll.add("VBB");
        coll.add(123);
        coll.add(new Date()); //添加

        System.out.println(coll.size()); // 长度

        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(123);
        coll.addAll(collection); //添加所有

        System.out.println(coll.isEmpty()); //判断是否空

//        coll.clear(); // 清空
        System.out.println(coll.contains("aa"));
        //看集合是否包含  比较的内容 如果对象 需要重写比较的方法 也很牛逼

        coll.add(new Mouse("xiaomi",22));
        System.out.println(coll.contains(new Mouse("xiaomi", 22)));
        Collection coll1 = Arrays.asList(123, "aa");
        System.out.println(coll.containsAll(coll1));


        coll.remove(new Mouse("xiaomi", 22));
        System.out.println(coll);
        System.out.println(coll.hashCode());
        Object[] objects = coll.toArray();  // 这个方法牛逼
        for (int i = 0; i <objects.length ; i++) {
            System.out.println(objects[i]);
        }
        List<Integer> ints = Arrays.asList(new Integer[]{123,587});
        //不是包装类 会只有一个元素。 要想都转换 需要用包装类  这个方法也牛逼
        System.out.println(ints);
        Iterator<Integer> iterator = ints.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next==5){
                iterator.remove();
            }
        }
    }
}
