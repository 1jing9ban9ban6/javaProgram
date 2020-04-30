package learn;

import javax.tools.FileObject;
import java.io.*;

/**
 * @author jing
 * @create 2020-04-27-17:47
 */
public class test1 {
    public static void main(String[] args) throws Exception {
        File file = new File("C:/Users/Administrator/Desktop/aa.txt");
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream("C:/Users/Administrator/Desktop/cc.txt");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes))!=-1){
            outputStream.write(bytes, 0, len);
        }
        outputStream.close();
        inputStream.close();
    }
}
