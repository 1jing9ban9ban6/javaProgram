package question3;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.time.chrono.MinguoChronology;

public class question2 {
    public static void main(String[] args) {
        // 二分查找
        int[] array ={1,2,3,4,6,7,8,9,10};
        question2 question2 = new question2();
        int i = question2.binSearch2(4, array,0,array.length-1);
        System.out.println(i);
    }

    public int binSearch(int key, int[] array) {
        int low = 0;
        int high = array.length - 1;
        int middle = 0;
        // 防止越界
        if (low > high || key < array[low] || key > array[high]) {
            return -1;
        }
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (array[middle] == key) {
                return middle;
            } else if (array[middle] > key) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
    public int binSearch2(int key, int[] array, int low,int high){
        int middle = low+(high-low)/2;
        if (key<array[low]||key>array[high]||low>high){
            return -1;
        }
        if (array[middle]==key){
            return middle;
        } else if (array[middle]<key){
            return binSearch2(key,array,middle+1,high);
        } else {
            return binSearch2(key,array, low,middle-1);
        }
    }
}
