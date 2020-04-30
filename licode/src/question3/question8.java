package question3;

import java.util.ArrayList;
import java.util.Arrays;

public class question8 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = question8.buildTree(preorder, inorder);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0){
            return null;
        }
        int nodeVal = preorder[0], inIndex = 0;
        for (int i=0;i<inorder.length; i++){
            if (inorder[i]==nodeVal){
                inIndex = i;
                break;
            }
        }
        TreeNode node = new TreeNode(nodeVal);
        node.left = buildTree(Arrays.copyOfRange(preorder,1,inIndex+1), Arrays.copyOfRange(inorder,0, inIndex));
        node.right = buildTree(Arrays.copyOfRange(preorder, inIndex+1, inorder.length),Arrays.copyOfRange(inorder, inIndex+1, inorder.length));
        return node;
    }

}
