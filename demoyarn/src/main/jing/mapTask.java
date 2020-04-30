package main.jing;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 *  四个泛型 分别为 maptask 读取不同文件的偏移量
 *                         你读取到一行的数据
 *                         我要返回的key的值
 *                         我要返回的value值
 */
public class mapTask extends Mapper<LongWritable, Text, Text, IntWritable> {
    // 重写父类里面的mapper方法 构造自己的逻辑
    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        // 切单词
        String line = value.toString();
        String[] words = line.split(" ");
        for(String word:words){
            context.write(new Text(word), new IntWritable(1));

        }
    }
}
