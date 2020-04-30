package ioTest;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;

/**
 * @author jing
 * @create 2020-02-28-15:31
 */
public class test2 {
    @Test
    public void test1() throws Exception{
        File file = new File("hello.txt");
        FileWriter writer = new FileWriter(file, true);
        // true 追加 flase 覆盖 看你怎么选 而且文件不存在帮你创建 非常牛逼
        writer.write("hualihushao");
        writer.close();
    }
}
