package Thread;

public class demo2 implements Runnable {

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        demo2.name = name;
    }

    private static String name;
    @Override
    public void run() {
        System.out.println("哦...."+name);
    }
}
