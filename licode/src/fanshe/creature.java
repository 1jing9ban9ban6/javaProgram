package fanshe;

import java.io.Serializable;

/**
 * @author jing
 * @create 2020-03-01-14:43
 */
public class creature<T> implements Serializable {
    private char gender;
    public double weight;
    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }
}
