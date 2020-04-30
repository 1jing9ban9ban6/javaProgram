package fanshe;

/**
 * @author jing
 * @create 2020-03-01-14:43
 */
public class person extends creature<String> implements Comparable<String>, myInterface{
    private String name;
    int age;
    public int id;
    public person(){}
    private person(String name){
        this.name = name;
    }
    private int show(String name, int id){
        return Integer.parseInt(name)+id;
    }
    private static String show1(String name, int id){
        return name+id;
    }
    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
