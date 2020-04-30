package ioTest;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author jing
 * @create 2020-02-28-10:41
 */
public class test1 {
    public static void main(String[] args) throws Exception {
        FileReader fr = null;
        try {
            // main方法是相当于工程 test是相当于module
            // file 只是对文件来操作并未涉及到对文件的写读 如果需要需要io流
            // 后序file类的对象会作为参数传到io流的构造器中
            // 构造器1
            File file = new File("hi2.txt");//相对路径 相对于moduleG：\javaprog....
            // 绝对路径是 包含盘符的一个路径
//        new File("D:/DD","JS"); // 在p的目录下的js文件
//        new File(file,"dd"); // 在file目录下的dd文件
            fr = new FileReader(file);
            // 返回读入的一个字符如果到达末尾返回-1
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close(); // 流的关闭操作
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void fileTest() {
        // 常用功能更
        File file = new File("hello.txt");
        File file1 = new File("E:/io/hi.txt");
        File file2 = new File("H:\\迅雷下载\\support\\1");
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getName());
//        System.out.println(file.getParent()); // 相对路径看不到 parent
//        System.out.println(file.lastModified());
//        System.out.println(file.length());
//        System.out.println(file.getPath());
        String[] list = file2.list();// 返回目录下的所有文件名字
        File[] files = file2.listFiles(); //返回下一层的目录对象
        for (String s : list) {
            System.out.println(s);
        }
        for (File fileH : files) {
            System.out.println(fileH.getAbsolutePath());
        }
    }

    @Test
    public void nameTest() throws IOException {
        File file = new File("hello.txt");
        File file1 = new File("E:/io/hi.txt");
        boolean b = file.renameTo(file1); // 改名且移动 要想成功需要file1在硬盘不存在 但是file要在
        System.out.println(b);
        File file2 = new File("hi.txt");
        file2.createNewFile();
    }

    @Test
    public void test2() {
        FileReader reader = null;
        try {
            //操作规范 1file类的实例化 2fileStream实例化 3流入的操作 4关闭流
            File file = new File("hi.txt");
            reader = new FileReader(file);
            char[] chars = new char[5];
            int len;
            while ((len = reader.read(chars)) != -1) {// 每次返回读取到的个数
//                for (int i = 0; i < len; i++) {
//                    System.out.print(chars[i]);
//                }
                String s = new String(chars, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
