package question4;

public class testUsb {
    public static void main(String[] args) {
        mp3 mp3 = new mp3();
        computer computer = new computer();
        computer.transform(mp3); //1
        computer.transform(new mp3());//2
        computer.transform(new usb() {//3
            @Override
            public void start() {
                System.out.println("2");
            }

            @Override
            public void end() {
                System.out.println("mp3 = " + mp3);
            }
        });
        usb usb = new mp3();
        computer.transform(usb);//4
    }
}
