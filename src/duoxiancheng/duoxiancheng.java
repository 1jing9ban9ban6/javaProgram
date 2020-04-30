package duoxiancheng;

public class duoxiancheng implements Runnable{
    int kc;
    public duoxiancheng(int kc){
        this.kc = kc;
    }
    @Override
    public void run() {

        synchronized ("aa"){

            while (kc > 0) {


                System.out.println(kc);
                this.kc = this.kc - 1;

            }
        }
    }
}
