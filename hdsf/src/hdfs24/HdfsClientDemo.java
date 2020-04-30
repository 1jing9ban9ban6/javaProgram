package hdfs24;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.util.Classpath;

import javax.sound.midi.SoundbankResource;
import javax.xml.transform.Source;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class HdfsClientDemo {
    public static void main(String[] args) throws Exception{
        /*
            Configuration参数对象机制：
               构造时，会加载jar包中的默认配置xx-default.xml
               再加载 用户配置xx-site.xml，覆盖掉默认参数
               构造完成之后，还可以conf.set("p","v"),会再次覆盖用户配置文件中的参数值
        */
        // new Configuration()会从项目的classpath中加载core-default.xml hdfs-default.xml core-site.xml
        // hdfs-site.xml等文件。
        Configuration conf = new Configuration();
        // 指定本客户端上传到hdfs 副本数为2
        conf.set("dfs.replication", "2");
        // 指定本客户端上传到hdfs 切块的规格大小 64M
        conf.set("dfs.blocksize","64m");
        // 构造一个访问hdfs的客户端对象 hdfs的uri，客户端要特别指定的参数，客户端的身份（用户名）
        FileSystem fs = FileSystem.get(new URI("hdfs://hdp-01:9000/"), conf, "root");
        //上传一个文件到hdfs里去
        fs.copyFromLocalFile(new Path("G:/机器学习/Hadoop大数据处理技术基础与实践.pdf"),
                new Path("/user/jing"));
        fs.close();
    }
    FileSystem fs = null;
    public void init() throws Exception{
        Configuration conf = new Configuration();
        conf.set("dfs.replication", "2");
        conf.set("dfs.blocksize","64m");
        fs = FileSystem.get(new URI("hdfs://hdp-01:9000/"), conf, "root");
    }
    public void testGet() throws Exception{
        init();
        // 从hdfs下载文件到本地客户端磁盘
        fs.copyToLocalFile(new Path("/user/jing"), new Path("G:/机器学习/"));
        fs.close();
    }
    public void testRename() throws Exception {
        // 在hdfs内部移动文件,修改名称
        init();
        fs.rename(new Path("cong"), new Path("dao"));
        fs.close();
    }
    public void mkdir() throws Exception {
        // 在hdfs中创建文件夹
        init();
        fs.mkdirs(new Path("lujing/wenjianming"));
        fs.close();
    }
    public void testRm() throws Exception {
        // 删除文件夹 true 为递归删除
        init();
        fs.delete(new Path("lujing"), true);
        fs.close();
    }
    public void testls1() throws Exception {
        // 查询hdfs指定目录下的信息 不返回文件夹信息 true 表示可以递归
        init();
        RemoteIterator<LocatedFileStatus> iter = fs.listFiles(
                new Path("dizhi"), true);
        while (iter.hasNext()){
            LocatedFileStatus status = iter.next();
            System.out.println("文件全路径"+status.getPath());
            System.out.println("块大小"+status.getBlockSize());
            System.out.println("文件块长度"+status.getLen());
            System.out.println("副本数量"+status.getReplication());
            System.out.println("块信息"+Arrays.toString(status.getBlockLocations()));
            System.out.println("-----------------------------");

        }
        fs.close();
    }
    public void testls2() throws Exception {
        // 查询hdfs指定目录下的信息 返回文件夹信息 文件夹没有块信息
        init();
        FileStatus[] listStatus = fs.listStatus(new Path("/"));
        for(FileStatus status:listStatus) {
            System.out.println("文件全路径" + status.getPath());
            System.out.println(status.isDirectory()?"这是文件夹":"这是文件");
            System.out.println("块大小" + status.getBlockSize());
            System.out.println("文件块长度" + status.getLen());
            System.out.println("-----------------------------");
        }
        fs.close();
    }
}
