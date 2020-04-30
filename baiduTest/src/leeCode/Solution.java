package leeCode;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author jing
 * @create 2020-04-08-10:50
 */
public class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
//        TreeNode1 node3 = new TreeNode1(3);
//        TreeNode1 node9 = new TreeNode1(9);
//        TreeNode1 node20 = new TreeNode1(20);
//        TreeNode1 node15 = new TreeNode1(15);
//        TreeNode1 node7 = new TreeNode1(7);
//        node3.left = node9;
//        node3.right = node20;
//        node20.left = node15;
//        node20.right = node7;
        TreeNode1 node1 = new TreeNode1(1);
        TreeNode1 node2 = new TreeNode1(2);
        TreeNode1 node3 = new TreeNode1(3);
        TreeNode1 node4 = new TreeNode1(4);
        TreeNode1 node5 = new TreeNode1(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
//        List<List<Integer>> lists = levelOrder(node3);
//        System.out.println(lists);
        Solution solution = new Solution();
        System.out.println(solution.serialize(node1));

    }
//    public static List<List<Integer>> levelOrder(TreeNode1 root) {
//        if (root == null) return null;
//        Queue<TreeNode1> queue = new LinkedList<>();
//        queue.offer(root);
//        List<List<Integer>> re = new ArrayList<>();
//        while (!queue.isEmpty()){
//            List<Integer> list = new ArrayList<>();
//            for (int i = queue.size(); i > 0 ; i--) {
//                TreeNode1 node = queue.poll();
//                list.add(node.val);
//                if(node.left != null) queue.add(node.left);
//                if(node.right != null) queue.add(node.right);
//            }
//            re.add(list);
//        }
//        return re;
//    }
    public String serialize(TreeNode1 root) {
        levelOrder(root);
        return list.toString();
    }
    void levelOrder(TreeNode1 root){
        if (root == null) return;
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode1 node = queue.poll();
            list.add(node.val);
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
    }
//    public TreeNode1 deserialize(String data) {
//
//    }
}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int x) {
        val = x;
    }
}


