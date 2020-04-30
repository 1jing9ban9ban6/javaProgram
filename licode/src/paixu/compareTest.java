package paixu;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jing
 * @create 2020-02-25-11:10
 */
public class compareTest {
    @Test
    public void testCompare(){
        Mouse[] mice = new Mouse[5];
        mice[0]=new Mouse("xiaomi",12);
        mice[1]=new Mouse("huawei",55);
        mice[2]=new Mouse("leishe",138);
        mice[3]=new Mouse("shuangfeiyan",30);
        mice[4]=new Mouse("qinghuaziguang",20);
//        Arrays.sort(mice);
//        System.out.println(Arrays.toString(mice));
        Arrays.sort(mice, new Comparator<Mouse>() {
            @Override
            public int compare(Mouse o1, Mouse o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(mice));
    }

}
