package SetMap;

/**
 * @author jing
 * @create 2020-02-27-16:39
 */
public class person implements Comparable{
    private String name;
    private int age;

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

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof person){
            person o1 = (person) o;
            return this.getName().compareTo(o1.getName());
        } else {
            throw new RuntimeException("类型不匹配");
        }
    }
}
