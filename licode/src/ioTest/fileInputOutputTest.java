package ioTest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jing
 * @create 2020-02-28-17:49
 */
public class fileInputOutputTest {
    @Test
    public void test1(){
        FileInputStream is = null;
        FileOutputStream os = null;
        try {
            // 如果是文本文件txt java c c++ 使用字符流来处理，非文本文件使用字节流来处理
            File src = new File("daitu.jpg");
            File desc = new File("obito.jpg");
            is = new FileInputStream(src);
            os = new FileOutputStream(desc); // 没有缓冲流 处理流
            byte[] bytes = new byte[5];
            int len;
            while ((len=is.read(bytes))!=-1){
                os.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
