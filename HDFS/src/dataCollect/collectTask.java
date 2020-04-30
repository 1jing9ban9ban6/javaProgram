package dataCollect;

import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.File;
import java.io.FilenameFilter;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public class collectTask extends TimerTask {
    @Override
    public void run() {
        try {
            Properties props = propertiesHoldLazy.getProp();
            // 构造log4j对象
            Logger logger = Logger.getLogger("logRollingFile");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH");

            String date = dateFormat.format(new Date());
            // 日志源目录地址
            File srcDir = new File(props.getProperty(constants.LOG_SOURCE_DIR));
            // 列出日志源目录中需要采集的文件
            File[] files = srcDir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    if (name.startsWith(props.getProperty(constants.LOG_LEGAL_PREFIX))){
                        return true;
                    }
                    return false;
                }
            });
            // 记录日志
            logger.info("探测到如下文件需要采集"+ Arrays.toString(files));

            // 移动到待上传目录
            File upToLoadDir = new File(props.getProperty(constants.LOG_TOUPLOAD_DIR));

            for (File file:files){
                FileUtils.moveFileToDirectory(file, upToLoadDir, true);
            }
            // 记录日志
            logger.info("探测到文件移动到待上传"+upToLoadDir.getAbsolutePath());

            // 构造一个hdfs客户端
            FileSystem fs = FileSystem.get(new URI(props.getProperty(constants.HDFS_URI)), new Configuration(), "student");
            File[] toUpLoadFiles = upToLoadDir.listFiles();
            // 日志内容的前路径
            Path hdfsDestPath = new Path(props.getProperty(constants.HDFS_DEST_BASE_DIR)+date);
            // 检查这个路径是否存在 如果不存在则创建该目录
            if (!fs.exists(hdfsDestPath)){
                fs.mkdirs(hdfsDestPath);
            }
            // 本地的备份目录
            File backUpDir = new File(props.getProperty(constants.LOG_BACKUP_BASE_DIR) + date + "/");
            if(!backUpDir.exists()){
                backUpDir.mkdirs();
            }
            for (File file:toUpLoadFiles){
                // 传输文件到HDFS并且改名字
                 fs.copyFromLocalFile(new Path(file.getAbsolutePath()),
                        new Path(hdfsDestPath+"/"+props.getProperty(constants.HDFS_FILE_PREFIX)+
                                UUID.randomUUID()+props.getProperty(constants.HDFS_FILE_SUFFIX)));

                // 记录日志
                logger.info("探测到文件移动到 hdfs"+upToLoadDir.getAbsolutePath());

                file.renameTo(backUpDir);

                // 记录日志
                logger.info("探测到文件移动到本地备份"+upToLoadDir.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
