package sortUtil;

import java.util.ArrayList;

public class sortU<T> {

    public void sort(ArrayList<T> tList, bijiaoqi<T> bijiaoqi){
        for (int i = 0; i < tList.size()-1; i++){
            for (int j = 0; j < tList.size()-1-i; j++){
                boolean flag = bijiaoqi.bijiao(tList.get(j), tList.get(j+1));
                if (flag){
                    T temp = tList.get(j);
                    tList.set(j, tList.get(j+1));
                    tList.set(j+1, temp);
                }
            }
        }
    }
}
