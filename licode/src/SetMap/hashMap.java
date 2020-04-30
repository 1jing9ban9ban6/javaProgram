package SetMap;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.*;

/**
 * @author jing
 * @create 2020-02-27-16:20
 */
public class hashMap {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("aaa",123);
        map.put("123",1232);
        map.put(123,"ddd");
        map.put(null,12);
        // 迭代map 中的key
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("***************");
        // 迭代map  中的value
        Collection values = map.values();
        for (Object o:values) {
            System.out.println(o);
        }
        System.out.println("*******************");
        // 迭代 entry
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Map.Entry next = (Map.Entry) iterator1.next();
        }
    }
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        map.put(1,new person("li",18));
        map.put(2,new person("ma",23));
        map.put(4,new person("ai",42));
        map.put(3,new person("sun",53));
        map.put(5,new person("wang",12));
//        Set set = map.entrySet();
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()){
//            Map.Entry next = (Map.Entry) iterator.next();
//            System.out.println(next.getValue());
//        }
        System.out.println(map);
    }
    @Test
    public void test3() throws Exception{
        Properties properties = new Properties();
        FileInputStream is = new FileInputStream("jdbc.properties");
        properties.load(is); // 加载流的文件
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("password"));

    }
}
