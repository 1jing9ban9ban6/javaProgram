package com.jing.pojo;

public class course {
    private String course_id;
    private String title;
    private String dept_name;
    private float credits;

    public course(String course_id, String title, String dept_name, float credits) {
        this.course_id = course_id;
        this.title = title;
        this.dept_name = dept_name;
        this.credits = credits;
    }

    public course() {
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public float getCredits() {
        return credits;
    }

    public void setCredits(float credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "course{" +
                "course_id='" + course_id + '\'' +
                ", title='" + title + '\'' +
                ", dept_name='" + dept_name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
