package question3;

import javax.sound.midi.Soundbank;

public class question3 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 5, 4, 3, 2, 6, 7};//8 1-7 4  1-4 5-7 1 2 3 4 1 2 1 2
        int high = array.length-1;
        int low = 1,nums=0;
        int middle = (high+1)/2;
        while (true){
            for (int i =0;i<array.length;i++){
                if (array[i]>=low&&array[i]<=middle){
                    nums++;
                }
            }
            if (nums!=middle-low+1){
                if (low==middle){
                    System.out.println(low);
                    break;
                }
                nums = 0;
                high = middle;
                middle = (high+low)/2;
            } else {
                if (middle==high){
                    System.out.println(low);
                    break;
                }
                nums = 0;
                low = middle+1;
                middle = (high+low)/2;
            }
        }
    }
}
