package StringApi;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author jing
 * @create 2020-02-24-22:01
 */
public class stringApi {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /**
         * 可序列化 实现了比较大小的接口
         */
        String s = new String("javaee");
        System.out.println(s);
        StringBuffer sbf = new StringBuffer("javaee");
        StringBuilder sbl = new StringBuilder(15);
        sbf.append("aa");
        sbf.delete(0, 2);
        byte[] gbks = s.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));
        String concat = s.concat(sbf.toString());
        System.out.println(concat);

    }
}
