package juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author jing
 * @create 2020-03-22-9:39
 */
public class listDemo {
    public static void main(String[] args) {
//        Vector<String> list = new Vector<>();
//        List<Object> list = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }).start();
        }
    }
}
