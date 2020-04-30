package com.jing;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import java.io.IOException;

public class flowCountReducer extends Reducer<Text, flowCount, Text, flowCount>{
    @Override
    protected void reduce(Text key, Iterable<flowCount> values, Context context) throws IOException, InterruptedException {
        int up = 0;
        int down = 0;
        for (flowCount value:values){
            up = value.getuFlow() + up;
            down = value.getdFlow() + down;
        }
        context.write(key, new flowCount(up, down, key.toString()));
    }
}
