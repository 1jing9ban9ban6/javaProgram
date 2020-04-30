package question3;

import java.util.ArrayList;
import java.util.Arrays;

public class question7 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode tree=reConstructBinaryTree(preorder,inorder);
        System.out.println(tree.val);

    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //1.由前序遍历确认根节点
        int node=pre[0];
        TreeNode tree=new TreeNode(node);

        //2.由中序遍历确认左右子树节点
        ArrayList<Integer> leftTreeForIn=new ArrayList<>();
        ArrayList<Integer> rightTreeForIn=new ArrayList<>();
        int nodePosition=-1;
        for(int i=0;i<in.length;i++){
            if(in[i]==node){
                nodePosition=i;  //确认根节点在中序遍历中的位置
            }
            //根据根节点将左右子树的节点分别放入两个list中
            if(nodePosition<0){
                leftTreeForIn.add(in[i]);
            }else if(nodePosition>=0 && nodePosition<i){
                rightTreeForIn.add(in[i]);
            }
        }

        //3.为树添加左右子树
        if(leftTreeForIn.size()>0){
            TreeNode left;
            if(leftTreeForIn.size()==1){  //判断左子树是否有叶子节点，左子树只有1个节点则表示无叶子节点
                left=new TreeNode(leftTreeForIn.get(0));
            }else{ //有叶子节点则进行递归操作
                int[] leftTreeForPre=new int[leftTreeForIn.size()];
                for(int i=0;i<leftTreeForIn.size();i++){
                    leftTreeForPre[i]=pre[i+1];
                }
                left=reConstructBinaryTree(leftTreeForPre, Arrays.stream(leftTreeForIn.toArray(new Integer[]{})).mapToInt(Integer::valueOf).toArray());
            }
            tree.left=left;
        }

        if(rightTreeForIn.size()>0){
            TreeNode right;
            if(rightTreeForIn.size()==1){
                right=new TreeNode(rightTreeForIn.get(0));
            }else{
                int[] rightTreeForPre=new int[rightTreeForIn.size()];
                for(int i=0;i<rightTreeForIn.size();i++){
                    rightTreeForPre[i]=pre[i+1+leftTreeForIn.size()];
                }
                right=reConstructBinaryTree(rightTreeForPre,Arrays.stream(rightTreeForIn.toArray(new Integer[]{})).mapToInt(Integer::valueOf).toArray());
            }
            tree.right=right;
        }
        return tree;
    }
}
