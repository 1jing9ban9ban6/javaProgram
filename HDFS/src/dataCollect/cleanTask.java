package dataCollect;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimerTask;

public class cleanTask extends TimerTask {
    @Override
    public void run() {
        try {
            // 日期的格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH");
            Properties props = propertiesHoldLazy.getProp();
            // 获取当前时间
            Date date = new Date();
            long now = date.getTime();

            // 备份的文件目录 获取列表
            File backUpDir = new File(props.getProperty(constants.LOG_BACKUP_BASE_DIR));
            File[] dayBackDir = backUpDir.listFiles();

            // 遍历每一个文件名 获取日志   日期的长整型 和当前时间比较   如果超过了24小时就删除
            for(File file:dayBackDir){
                long time = sdf.parse(file.getName()).getTime();
                if (now-time > Integer.parseInt(props.getProperty(constants.LOG_BACKUP_TIMEOUT))*60*60*1000L){
                    FileUtils.deleteDirectory(file);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
