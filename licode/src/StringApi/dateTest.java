package StringApi;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jing
 * @create 2020-02-24-22:31
 */
public class dateTest {
    public static void main(String[] args) throws ParseException {
        /**
         *  string 转为sql.date的类型 然后就能存入数据库了
         */
        String birth="2020-06-24";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse(birth);
        java.sql.Date date = new java.sql.Date(parse.getTime());
        System.out.println(date);

    }
    @Test
    public void test1(){
        String s = "中";
        byte[] bytes = s.getBytes();
        System.out.println(bytes.length);
        System.out.println(bytes[0]);
    }
}
