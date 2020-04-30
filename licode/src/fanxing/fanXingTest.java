package fanxing;

/**
 * @author jing
 * @create 2020-02-27-20:33
 */
public class fanXingTest<T> {
    private String name;
    private int age;
    T desc;

    public fanXingTest() {
    }


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

    public T getDesc() {
        return desc;
    }

    public void setDesc(T desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "fanXingTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", desc=" + desc +
                '}';
    }

    public fanXingTest(String name, int age, T desc) {
        this.name = name;
        this.age = age;
        this.desc = desc;
    }
}

