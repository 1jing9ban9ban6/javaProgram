package com.jing;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class flowCountMapper extends Mapper<LongWritable, Text, Text, flowCount>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        // 以制表符为间隔切割数据
        String[] split = line.split("\t");
        // 电话作为key 是1
        String phone = split[1];
        // 上传和下载数据
        int upFlow = Integer.parseInt(split[split.length - 3]);
        int downFlow = Integer.parseInt(split[split.length - 2]);
        context.write(new Text(phone), new flowCount(upFlow, downFlow, phone));
    }
}
