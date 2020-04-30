package hdfs24;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Arrays;

public class HDFSClientDemo {
    FileSystem fs = null;

    @Before
    public void init() throws Exception{
        /**
         *  conf 先加载jar包中的默认配置，然后加载用户配置文件，最后set方法再覆盖
         */
        // 构造客户端 new的时候这个对象会自动去找客户端默认的配置文件
        Configuration conf = new Configuration();
        // 可以指定本客户端上传到hdfs时的副本数量
        conf.set("dfs.replication","2");
        // 指定本客户端上传到hdfs时的切块大小
        conf.set("dfs.blocksize","64m");
        // 告诉HDFS的地址 url，一些规格说明，告诉hdfs 客户端的身份 只是构造了这个客户端对象
        fs = FileSystem.get(new URI("hdfs://192.168.192.3"), conf, "student");
    }
    @Test
    public void upload() throws Exception {
        // 上传文件到HDFS
        fs.copyFromLocalFile(new Path("F:/a.txt"), new Path("/user/jing/input/"));
        fs.copyFromLocalFile(new Path("F:/b.txt"), new Path("/user/jing/input/"));
        fs.copyFromLocalFile(new Path("F:/c.txt"), new Path("/user/jing/input/"));
        fs.copyFromLocalFile(new Path("F:/d.txt"), new Path("/user/jing/input/"));
        fs.close();
    }


    @Test
    public void get() throws Exception{
        /**
         *  从hdfs里面下载文件到本地
         */
        fs.copyToLocalFile(new Path("/user/jing/input/a.txt"), new Path("g:/jing/wordcount/"));
        fs.copyToLocalFile(new Path("/user/jing/input/b.txt"), new Path("g:/jing/wordcount/"));
        fs.copyToLocalFile(new Path("/user/jing/input/c.txt"), new Path("g:/jing/wordcount/"));
        fs.copyToLocalFile(new Path("/user/jing/input/d.txt"), new Path("g:/jing/wordcount/"));
        fs.close();
    }

    @Test
    public void rename() throws Exception{
        /**
         *  从hdfs里面移动目录
         */
        fs.rename(new Path("/user/Sci-Hub.zip"), new Path("/user/wuhaitao/"));
        fs.rename(new Path("/user/openvpn.rar"), new Path("/user/wuhaitao/"));
        fs.close();
    }

    @Test
    public void mkdir() throws Exception{
        /**
         *  从hdfs里面创建文件夹爱
         */
        fs.mkdirs(new Path("/user/jing/output"));
        fs.close();
    }

    @Test
    public void remove() throws Exception{
        /**
         *  从hdfs里面删除文件夹
         */
        fs.delete(new Path("/user/jing/Sci-Hub.zip"),true);
        fs.close();
    }

    @Test
    public void ls() throws Exception{
        /**
         *  从hdfs里面查询指定目录的文件,不显示文件夹
                */
        RemoteIterator<LocatedFileStatus> iter = fs.listFiles(new Path("/user/wuhaitao/"), true);
        while (iter.hasNext()){
            LocatedFileStatus lf = iter.next();
            System.out.println(lf.getOwner());
            System.out.println(Arrays.toString(lf.getBlockLocations()));
            System.out.println(lf.getLen());
        }
        fs.close();
    }
    @Test
    public void ls2() throws Exception{
        /**
         *  从hdfs里面查询文件夹和文件 只看下面的一级
         */
        FileStatus[] file = fs.listStatus(new Path("/user/wuhaitao/"));
        for (int i = 0; i < file.length;i++){
            System.out.println(file[i].isDirectory()?"这是文件夹":"这是文件");
            System.out.println(file[i].getLen());
            System.out.println(file[i].getBlockSize());
            System.out.println(file[i].getPath());
            System.out.println("-------------------");
        }
        fs.close();
    }

    @Test
    public void readDataTest() throws Exception{
         //读HDFS的文件数据
        FSDataInputStream data = fs.open(new Path("/user/wuhaitao/gan.txt"));
//        byte[] bytes = new byte[2048];
//        int read = data.read(bytes);
//        System.out.println(new String(bytes));
//        data.close();
//        fs.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(data));
        String line = null;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
        fs.close();
    }
    @Test
    public void writeTest() throws Exception{
        // 向HDFS系统中写数据
        FSDataOutputStream out = fs.create(new Path("/user/jing/hello.jpg"), false);
        // 我要写入一张图片，首先得从本地拿到一张图片
        FileInputStream in = new FileInputStream("C:/Users/Administrator/Pictures/Saved Pictures/daitu.jpg");
        // 构建一个字节数据用来存放缓冲流
        byte[] bytes = new byte[1024];
        int read = 0;
        while ((read=in.read(bytes))!=-1){
            out.write(bytes,0, read);
        }
        // 释放资源
        in.close();
        out.close();
        fs.close();
    }
}
