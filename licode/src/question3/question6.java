package question3;

import java.util.ArrayList;
import java.util.Arrays;

public class question6 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ArrayList<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
        }
        list.sort(Integer::compareTo);
        Integer[] array = list.toArray(new Integer[list.size()]);
        Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
    }
}
