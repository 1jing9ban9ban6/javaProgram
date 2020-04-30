package datacollet;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class BackupCleanTask extends TimerTask {
    public void run() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
        long now = new Date().getTime();
        //探测备份目录
        try {
            File backupBaseDir= new File("g:/hadoop_program/backup/");
            File[] dayBackDir = backupBaseDir.listFiles();
            //判断备份日期子目录是否已超24小时
            for(File dir : dayBackDir) {
                long time = sdf.parse(dir.getName()).getTime();
                if(now-time>24*60*60*1000L){
                    FileUtils.deleteDirectory(dir);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
