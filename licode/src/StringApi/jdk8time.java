package StringApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author jing
 * @create 2020-02-25-10:09
 */
public class jdk8time {
    public static void main(String[] args) {
        // 实例化
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        // 设置 不加偏移量的年月日
        LocalDateTime.of(2020,8,7,20,30);
        // 这个类 拥有不可变性  with （set）
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);
        System.out.println(localDateTime1);
        System.out.println(localDateTime);
        // get
        localDateTime.getDayOfWeek();
        // plus
        LocalDateTime localDateTime2 = localDateTime.plusMinutes(10);
        System.out.println(localDateTime2);
        System.out.println(localDateTime);
    }
}
