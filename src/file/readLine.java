package file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class readLine {
    public static void main(String args[]) throws Exception {
        // 按行读取文件
        BufferedReader bf = new BufferedReader(
            new InputStreamReader(new FileInputStream("G:/flie/hello.txt"),
                    "gbk"));
        String rl;
        while ((rl = bf.readLine())!=null){
            System.out.println(rl);
        }
    }
}
