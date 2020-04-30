package com.jing.mybatis.model;

public class takes {
  private String courseId;
  private String secId;
  private String semester;
  private float year;
  private String grade;
  private student student;

  public takes() {}

    public takes(String courseId, String secId, String semester,
                 float year, String grade, com.jing.mybatis.model.student student) {
        this.courseId = courseId;
        this.secId = secId;
        this.semester = semester;
        this.year = year;
        this.grade = grade;
        this.student = student;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public float getYear() {
        return year;
    }

    public void setYear(float year) {
        this.year = year;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public com.jing.mybatis.model.student getStudent() {
        return student;
    }

    public void setStudent(com.jing.mybatis.model.student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "takes{" +
                "courseId='" + courseId + '\'' +
                ", secId='" + secId + '\'' +
                ", semester='" + semester + '\'' +
                ", year=" + year +
                ", grade='" + grade + '\'' +
                ", student=" + student +
                '}';
    }
}
