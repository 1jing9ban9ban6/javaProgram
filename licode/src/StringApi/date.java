package StringApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jing
 * @create 2020-02-24-22:14
 * jdk8 lang date
 *      sql date
 *      simpleDateFormat  将日期 转化成符合规范的字符串 ----string date
 */
public class date {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        long time = date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat();
        // 格式化日期 ---string 20-2-24 下午10:20 转为了 中文的
        String format = sdf.format(date);
        System.out.println(format);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // 要符合格式
        // 两个方法 一个格式化 一个解析

        System.out.println(format1.format(date));
        System.out.println(time);
        // 解析 把string 转为date
        Date parse = format1.parse("2020-02-24 10:25:23");
        System.out.println(parse);
    }
}
