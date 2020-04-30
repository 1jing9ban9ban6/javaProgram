package com.jing;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 *  要保留空参构造才可以反序列化
 *  参数顺序要一致
 */
public class flowCount implements Writable {
    private int uFlow;
    private int dFlow;
    private int sumFlow;
    private String phone;

    public int getuFlow() {
        return uFlow;
    }

    public void setuFlow(int uFlow) {
        this.uFlow = uFlow;
    }

    public int getdFlow() {
        return dFlow;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setdFlow(int dFlow) {
        this.dFlow = dFlow;
    }
    public flowCount(){

    }

    public flowCount(int uFlow, int dFlow, String phone) {
        this.phone = phone;
        this.uFlow = uFlow;
        this.dFlow = dFlow;
        this.sumFlow = uFlow+dFlow;
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(uFlow);
        dataOutput.writeInt(dFlow);
        dataOutput.writeInt(sumFlow);
        dataOutput.writeUTF(phone);
    }

    public void readFields(DataInput dataInput) throws IOException {
        this.uFlow = dataInput.readInt();
        this.dFlow = dataInput.readInt();
        this.sumFlow = dataInput.readInt();
        this.phone = dataInput.readUTF();
    }

    @Override
    public String toString() {
        return uFlow + "," + dFlow + "," + sumFlow + "\r\n";
    }
}
