package com.jing;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class jobSubmitFlowCount{
    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        job.setJarByClass(jobSubmitFlowCount.class);

        job.setMapperClass(flowCountMapper.class);
        job.setReducerClass(flowCountReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(flowCount.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(flowCount.class);

        FileInputFormat.setInputPaths(job,
                new Path("G:/英雄时刻/新建文件夹/04-Hadoop Hive Hbase Flume Sqoop-12天/Hadoop-day04-MapReduce编程案例1/课件与资料/练习用的数据"));
        FileOutputFormat.setOutputPath(job, new Path("G:/jing/wordcount/output2"));

        job.waitForCompletion(true);
    }
}
