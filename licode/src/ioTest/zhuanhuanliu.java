package ioTest;

import org.junit.Test;

import java.io.*;

/**
 * @author jing
 * @create 2020-02-28-21:13
 */
public class zhuanhuanliu {
    @Test
    public void test1(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            // 字节转字符 就是编码格式改变
            isr = new InputStreamReader(
                    new FileInputStream(new File("n1.txt")),"utf-8");
            osw = new OutputStreamWriter(
                    new FileOutputStream(new File("n3.txt")), "gbk");
            char[] chars = new char[1024];
            int len;
            while ((len=isr.read(chars))!=-1){
                osw.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
