package question2;


import javax.lang.model.element.VariableElement;

public class question4 {
    public static void main(String[] args) {
        TreeNode nodes = null;
        int var = 4;
    }
    public TreeNode searchBST(TreeNode node, int var){
        if (node==null) return null;
        if (node.val==var) return node;
        return searchBST(node.left,var);
    }
}
