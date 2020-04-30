package com.jing.mybatis.model;

public class instructor {
    private String Id;
    private String instructorName;
    private String deptName;
    private float salary;

    public instructor() {
    }

    public instructor(String id, String instructorName, String deptName, float salary) {
        Id = id;
        this.instructorName = instructorName;
        this.deptName = deptName;
        this.salary = salary;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "instructor{" +
                "Id='" + Id + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
