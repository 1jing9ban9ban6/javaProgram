package sortUtil;

import java.util.ArrayList;

public class sortPUTong {
    public void sort(ArrayList<shangPin> tList){
        for (int i = 0; i < tList.size()-1; i++){
            for (int j = 0; j < tList.size()-1-i; j++){
                int re = tList.get(j).sort(tList.get(j+1));
                if (re>0){
                    shangPin temp = tList.get(j);
                    tList.set(j, tList.get(j+1));
                    tList.set(j+1, temp);
                }
            }
        }

    }
}
