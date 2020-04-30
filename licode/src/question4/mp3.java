package question4;

public class mp3 implements usb {
    @Override
    public void start() {
        System.out.println("mp3开始工作了");
    }

    @Override
    public void end() {
        System.out.println(this.getClass()+"开始工作了");
    }
}
