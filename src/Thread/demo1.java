package Thread;

public class demo1 implements Runnable{


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void run() {
        System.out.println("啊....."+name);
    }
}
