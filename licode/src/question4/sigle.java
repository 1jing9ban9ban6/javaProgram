package question4;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.stream.Entity;

public class sigle {
    public static void main(String[] args) {
        bank bank = question4.bank.getBank();
    }
}
class bank{
    //私有化构造器

    private bank(){}
    private static bank bank = new bank();

    public static question4.bank getBank() {
        return bank;
    }
}
