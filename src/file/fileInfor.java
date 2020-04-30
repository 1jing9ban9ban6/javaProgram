package file;

import java.io.File;

public class fileInfor {
    public static void main(String args[]){
        File file = new File("G:/英雄时刻.");
        // 创建新文件
//        file.mkdirs(); mkdir 不能递归创建，mkdirs可以
        // 找到文件的绝对路径
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        // 判断这是否是一个文件夹
        boolean directory = file.isDirectory();
        System.out.println(directory);
        // 判断这是否是一个文件
        boolean file1 = file.isFile();
        System.out.println(file1);
        // 获取文件名
        String name = file.getName();
        // 获取上级目录返回的是上级路径的对象
        File parentFile = file.getParentFile();
        parentFile.getName();
        // 返回所有上级目录的路径
        String parent = file.getParent();
        // 获取文件长度
        long length = file.length();
        System.out.println(length);
        // 文件的子文件名
//        String[] lists = file.list();
//        for (String list:lists){
//            System.out.println(list);
//        }
        // 文件的子文件路径
        File[] files = file.listFiles();
        for (File file2:files){
            System.out.println(file2.length());
        }
    }
}
