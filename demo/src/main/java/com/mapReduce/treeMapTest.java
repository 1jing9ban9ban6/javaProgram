package com.mapReduce;

import com.jing.flowCount;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class treeMapTest {
    public static void main(String[] args) {
        // 构造treeMap内部类重写比较规则
        TreeMap<flowCount, String> tree = new TreeMap(new Comparator<flowCount>() {
            public int compare(flowCount o1, flowCount o2) {
                if ((o2.getuFlow()+o2.getdFlow())==(o1.getuFlow()+o1.getdFlow())){
                    return o1.getPhone().compareTo(o2.getPhone());
                }
                return (o2.getuFlow()+o2.getdFlow())-(o1.getuFlow()+o1.getdFlow());
            }
        });

        // 构造实例对象
        flowCount f1 = new flowCount(500, 300, "1367788");
        flowCount f2 = new flowCount(400, 200, "1367766");
        flowCount f3 = new flowCount(600, 400, "1367755");
        flowCount f4 = new flowCount(300, 500, "1367744");

        tree.put(f1, null);
        tree.put(f2, null);
        tree.put(f3, null);
        tree.put(f4, null);

        Set<Map.Entry<flowCount, String>> entries = tree.entrySet();
        for (Map.Entry<flowCount, String> entry:entries){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
