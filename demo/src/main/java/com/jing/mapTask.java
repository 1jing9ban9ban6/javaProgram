package com.jing;

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
        // 将读取到的一行 数据先转为string类型 然后按空格切分成为一个单词数组
        String s = value.toString();
        String[] words = s.split(" ");
        // 将每个单词都添加到context里面并且将值改为1，这样可以准备好reduce的前置操作
        for (String word:words){
            context.write(new Text(word), new IntWritable(1));
        }
    }
}
