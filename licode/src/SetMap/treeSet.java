package SetMap;

import org.junit.Test;
import paixu.Mouse;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author jing
 * @create 2020-02-26-21:05
 */
public class treeSet {
    public static void main(String[] args) {
        TreeSet<Mouse> mice = new TreeSet<>();
        mice.add(new Mouse("xiaomi",65));
        mice.add(new Mouse("huawei",70));
        mice.add(new Mouse("shuangfeiyan",80));
        mice.add(new Mouse("pingguo",100));
        mice.add(new Mouse("sanxing",30));
        mice.add(new Mouse("leishe",20));
        mice.add(new Mouse("qinghuaziguang",88));
        mice.add(new Mouse("qinghuaziguang",89));

        Iterator<Mouse> mouse = mice.iterator();
        while (mouse.hasNext()){
            System.out.println(mouse.next());
        }
    }
    @Test
    public void test2(){
        Comparator<Mouse> comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Mouse && o2 instanceof Mouse){
                    return Double.compare(((Mouse) o1).getPrice(),((Mouse) o2).getPrice());
                } else {
                    throw new RuntimeException("类型错误");
                }
            }
        };
        TreeSet<Mouse> mice = new TreeSet<>(comparator);
        mice.add(new Mouse("xiaomi1",65));
        mice.add(new Mouse("huawei2",70));
        mice.add(new Mouse("shuangfeiyan3",80));
        mice.add(new Mouse("pingguo4",100));
        mice.add(new Mouse("sanxing5",30));
        mice.add(new Mouse("leishe6",20));
        mice.add(new Mouse("qinghuaziguang7",88));
        mice.add(new Mouse("qinghuaziguang8",89));

        Iterator<Mouse> mouse = mice.iterator();
        while (mouse.hasNext()){
            System.out.println(mouse.next());
        }
    }
}
