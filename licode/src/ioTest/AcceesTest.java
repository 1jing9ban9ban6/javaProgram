package ioTest;

import java.io.RandomAccessFile;

/**
 * @author jing
 * @create 2020-02-29-16:41
 */
public class AcceesTest {
    public static void main(String[] args) throws Exception{
        RandomAccessFile file = new RandomAccessFile("n3.txt", "rw");
        // 这个类可以定义位置坐标操作数据
        file.seek(3L);
        byte[] bytes = new byte[10];
        StringBuilder builder = new StringBuilder((int) file.length());
        int len;
        while ((len = file.read(bytes))!=-1){
            builder.append(new String(bytes,0,len));
        }
        file.seek(3L);
        file.write("wocalei".getBytes());
        file.write(builder.toString().getBytes());
        file.close();
    }
}
