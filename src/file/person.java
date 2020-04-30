package file;

import java.io.Serializable;

public class person implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", IsMarried=" + isMarried +
                '}';
    }

    private int age;
    private float salary;
    private boolean isMarried;

    public person(){

    }

    public person(String name, int age, float salary, boolean isMarried){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.isMarried = isMarried;
    }
}
