package com.jing.di;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jing
 * @create 2020-03-05-18:17
 */
public class teacher {
    private String tId;
    private String tName;
    private List<String> cls;
    private List<student> studentList;
    private int[] ints;
    private Map<String,Integer> stuName;
    private Set<student> studentSet;

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public List<String> getCls() {
        return cls;
    }

    public void setCls(List<String> cls) {
        this.cls = cls;
    }

    public List<student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<student> studentList) {
        this.studentList = studentList;
    }

    public int[] getInts() {
        return ints;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    public Map<String, Integer> getStuName() {
        return stuName;
    }

    public void setStuName(Map<String, Integer> stuName) {
        this.stuName = stuName;
    }

    public Set<student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<student> studentSet) {
        this.studentSet = studentSet;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "tId='" + tId + '\'' +
                ", tName='" + tName + '\'' +
                ", cls=" + cls +
                ", studentList=" + studentList +
                ", ints=" + Arrays.toString(ints) +
                ", stuName=" + stuName +
                ", studentSet=" + studentSet +
                '}';
    }
}
