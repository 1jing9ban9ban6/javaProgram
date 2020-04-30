package question2;

import java.util.*;

public class question {
    public static void main(String[] args) {
//        给定一个包含 n 个整数的数组 nums 和一个目标值 target，
//        判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
//        找出所有满足条件且不重复的四元组。
//        注意：答案中不可以包含重复的四元组。
//        给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
        int[] nums = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
        List<List<Integer>> lists = new ArrayList<>();
        int target = 0, temp;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        temp = nums[i] + nums[j] + nums[k] + nums[l];
                        if (temp == target) {
                            List<Integer> arrayList = new ArrayList<>();
                            arrayList.add(nums[i]);
                            arrayList.add(nums[j]);
                            arrayList.add(nums[k]);
                            arrayList.add(nums[l]);
                            arrayList.sort(Integer::compareTo);
                            lists.add(arrayList);
                        }
                    }
                }
            }
        }
        Set<List<Integer>> set = new HashSet<>();
        for (List<Integer> a : lists)
            set.add(a);
        lists.clear();
        Iterator<List<Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            lists.add(iterator.next());
        }
        System.out.println(lists);
    }
}
