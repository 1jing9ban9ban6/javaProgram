package dataCollect;

import java.util.Timer;

public class collectMain {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new collectTask(),0,60*60*1000L);
        timer.schedule(new cleanTask(), 0, 60*60*1000L);
    }
}
