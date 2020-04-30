package leeCode;

import jdk.nashorn.internal.ir.Flags;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author jing
 * @create 2020-04-11-14:16
 */
public class levelTest {
    public static void main(String[] args) {
        TreeNode1 node5 = new TreeNode1(5);
        TreeNode1 node4 = new TreeNode1(4);
        TreeNode1 node8 = new TreeNode1(8);
        TreeNode1 node11 = new TreeNode1(11);
        TreeNode1 node13 = new TreeNode1(13);
        TreeNode1 node44 = new TreeNode1(4);
        TreeNode1 node7 = new TreeNode1(7);
        TreeNode1 node2 = new TreeNode1(2);
        TreeNode1 node55 = new TreeNode1(5);
        TreeNode1 node1 = new TreeNode1(1);
        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;
        node8.left = node13;
        node8.right = node44;
        node44.left = node55;
        node44.right = node1;
//        List<List<Integer>> lists = levelOrder(node3);
//        System.out.println(lists);
//        int[] ints = {1, 2, 5, 10, 6, 9, 4, 3}; //fa
//        int[] ints = {7,4,6,5}; fa
//        int[] ints = {4, 6, 12, 8, 16, 14, 10};
//        int[] ints = {5, 2, -17, -11, 25, 76, 62, 98, 92, 61};
//        System.out.println(verifyPost(ints, 0, ints.length - 1));
        levelTest test = new levelTest();
        System.out.println(test.pathSum(node5, 22));
    }

    public List<ArrayList<Integer>> a() {

        return new ArrayList<>();
    }

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode1 root, int sum) {
        recur(root, sum);
        return res;
    }

    public void recur(TreeNode1 node, int sum) {
        if (node == null) return;
        path.add(node.val);
        sum = sum - node.val;
        if (sum == 0 && node.left == null && node.right == null) {
            res.add(new LinkedList<>(path));
        }
        recur(node.left, sum);
        recur(node.right, sum);
        path.removeLast();
    }


    public static boolean verifyPost(int[] postOrder, int low, int high) {
        // low 开始是第一个元素 也就是0， high 开始为倒数第二个元素也就是下标是len-2
        if (low == high || high - low == 1) return true;
        int root = postOrder[high];
        int index = low;
        int num = 0;
        for (int i = low; i < high - 1; i++) {
            if (postOrder[i] < root && postOrder[i + 1] > root) {
                index = i;
                num++;
            }
        }
        if (num == 0) {
            if (postOrder[low] > root && postOrder[high - 1] < root) {
                return false;
            }
            return verifyPost(postOrder, low, high - 1);
        } else {
            for (int i = index + 1; i < high; i++) {
                if (postOrder[i] < root) {
                    return false;
                }
            }
            for (int i = low; i < index; i++) {
                if (postOrder[i] > root) {
                    return false;
                }
            }
            return verifyPost(postOrder, low, index) && verifyPost(postOrder, index + 1, high - 1);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode1 root) {
        List<List<Integer>> re = new ArrayList<>();
        if (root == null) return re;
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            if (flag) {
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode1 node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                re.add(list);
                flag = false;
            } else {
                Stack<Integer> stack = new Stack<>();
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode1 node = queue.poll();
                    stack.push(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                while (!stack.isEmpty()) {
                    list.add(stack.pop());
                }
                re.add(list);
                flag = true;
            }
        }
        return re;
    }
}
