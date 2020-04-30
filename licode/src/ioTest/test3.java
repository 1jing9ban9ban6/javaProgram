package ioTest;

import org.junit.Test;

import java.io.*;

/**
 * @author jing
 * @create 2020-02-28-18:52
 */
public class test3 {
    @Test
    public void test1(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File src = new File("n1.txt");
            File desc = new File("n2.txt");
            FileReader fr = new FileReader(src);
            FileWriter fw = new FileWriter(desc);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            char[] bytes = new char[10];
            int len;
            while ((len = br.read(bytes))!=-1){
                bw.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
