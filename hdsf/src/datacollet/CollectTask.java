package datacollet;

import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimerTask;
import java.util.UUID;
import java.util.logging.Logger;

public class CollectTask extends TimerTask {
    public void run(){
        //1，流程
        //    启动一个定时任务：
        //        --定时探测日志源目录
        //        --获取需要采集的文件
        //        --移动这些文件到一个待上传的临时目录
        //        --遍历待上传目录文件，逐个传输到hdfs的目标路径，同时将传输完成的
        //        文件移动到备份目录
        //
        //    启动一个定时任务：
        //        --探测备份目录中的备份数据，检查是否已超出最长备份时长，如果超出，则删除。
        // 获取本次采集的日期

        // 构造一个log4j日志对象
        Logger logger = Logger.getLogger("logRollingFile");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
        String day = sdf.format(new Date());
        File srcDir = new File("g:/hadoop_program/logs/accesslog/");
        // 列出原文件中要采集的文件
        File[] listFiles = srcDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.startsWith("acesslog.")){
                    return true;
                }
                return false;
            }
        });
        // 记录日志
        logger.info("探测到如下文件需要采集"+ Arrays.toString(listFiles));

        // 将要采集的文件上传到临时目录
        File toUpLoadDir = new File("g:/hadoop_program/logs/toupload/");
        try {
            for(File file:listFiles){
            FileUtils.moveFileToDirectory(file, toUpLoadDir, true);
            file.renameTo(toUpLoadDir);
        }

        // 记录日志
        logger.info("上述文件移动到了待上传目录"+ toUpLoadDir.getAbsolutePath());

        // 构造一个hdfs的客户端对象

            FileSystem fs = FileSystem.get(new URI("h"), new Configuration(), "root");
            File[] toUpLoadFiles = toUpLoadDir.listFiles();
            // 检查HDFS中日期目录是否存在，如果不存在就创建，
            Path hdfsDestPath = new Path("/jing/logs/" + day);
            if(!fs.exists(hdfsDestPath)){
                fs.mkdirs(hdfsDestPath);
            }
            // 检查本地的备份目录是否存在，如果不存在则创建。
            File backupDir = new File("g:/hadoop_program/backup/" + day+"/");
            if(!backupDir.exists()){
                backupDir.mkdirs();
            }
            for(File toUpLoadFile:toUpLoadFiles){
                // 传输文件到HDFS并改名
                Path destPath = new Path(hdfsDestPath + "/access_log" + UUID.randomUUID() + "log");
                fs.copyFromLocalFile(new Path(toUpLoadDir.getAbsolutePath()), destPath);
                // 记录日志
                logger.info("文件传输到HDFS完成"+ toUpLoadFile.getAbsolutePath()+"-->"+destPath);
                // 将传输完成的文件移动的备份目录
                FileUtils.moveFileToDirectory(toUpLoadFile, backupDir, true);
                // 记录日志
                logger.info("文件备份完成"+ toUpLoadFile.getAbsolutePath()+"-->"+backupDir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
