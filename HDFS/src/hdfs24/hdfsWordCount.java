package hdfs24;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class hdfsWordCount {
    public static void main(String[] args) throws Exception{

        // 反射创建接口对象
        Properties prop = new Properties();
        prop.load(hdfsWordCount.class.getClassLoader().getResourceAsStream("map.properties"));
        Class<?> mapper = Class.forName(prop.getProperty("countMapper"));
        mapper mapperIm = (mapper) mapper.newInstance();
        context context = new context();
//         去hdfs逐行读取
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.192.3"), new Configuration(), "student");
        RemoteIterator<LocatedFileStatus> iter = fs.listFiles(new Path(prop.getProperty("INPUT_PATH")), false);
        while (iter.hasNext()){
            LocatedFileStatus next = iter.next();
            FSDataInputStream data = fs.open(next.getPath());
            BufferedReader br = new BufferedReader(new InputStreamReader(data));
            String line = null;
            while ((line=br.readLine())!=null){
                // 调用一个方法对每一行进行业务处理
                mapperIm.map(line, context);
            }
        }
        // 将结果放入一个缓存
        HashMap<Object, Object> map = context.getContextMap();
        Set<Map.Entry<Object, Object>> entries = map.entrySet();

        FSDataOutputStream out = fs.create(new Path(prop.getProperty("OUTPUT_PATH")));

        for (Map.Entry<Object,Object> entry:entries){
            // 调用一个方法将缓存中的结果输出到HDFS结果文件
            out.write((entry.getKey()+" "+entry.getValue()+" ").getBytes());
        }

    }
}
