package StringApi;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author jing
 * @create 2020-02-25-10:20
 */
public class instan {
    public static void main(String[] args) {
        // java中记录 时间点的api 是一个数 有起始点 1970.0.0.0.0 类似于date 得到时间戳记录毫秒数
        Instant now = Instant.now();
        // DateTimeFormatter() 格式化解析日期或时间
        // 实例化
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime now1 = LocalDateTime.now();
        String format = isoLocalDateTime.format(now1); // 长得一样但是 类型不一样
        System.out.println(format);
        System.out.println(now1);
        // 解析
        TemporalAccessor parse = isoLocalDateTime.parse("2020-02-25T10:34:47.309");
        System.out.println(parse);
    }
}
