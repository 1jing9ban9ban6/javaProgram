package ioTest;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * @author jing
 * @create 2020-02-28-23:01
 */
public class datain {
    public static void main(String[] args) throws Exception{
        FileInputStream stream = new FileInputStream("h.txt");
        DataInputStream dataInputStream = new DataInputStream(stream);
        // 数据流 我草这个牛逼超级牛逼 对象流的前身 下面直接 存对象了 太吊了
    }
}
