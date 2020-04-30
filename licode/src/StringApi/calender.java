package StringApi;

import java.util.Calendar;
import java.util.Date;

/**
 * @author jing
 * @create 2020-02-25-9:35
 */
public class calender {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.get(Calendar.DAY_OF_MONTH)); //get

        instance.set(Calendar.DAY_OF_WEEK,8);
        System.out.println(instance.get(Calendar.DAY_OF_WEEK)); //add

        instance.add(Calendar.DAY_OF_WEEK,3);
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));

        Date time = instance.getTime(); //获取日历类 getTime
        System.out.println(time);

        Date date = new Date();
        instance.setTime(date); //setTime
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));
    }
}
