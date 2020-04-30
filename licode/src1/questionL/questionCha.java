package questionL;

/**
 * @author jing
 * @create 2020-03-26-9:37
 */
public class questionCha {
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null) return null;
        if (root.left!=null) mirrorTree(root.left);
        if (root.right!=null) mirrorTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
    public boolean isSymmetric(TreeNode root) {
        return root==null? true: cur(root.left, root.right);
    }
    public boolean cur(TreeNode L, TreeNode R){
        if (L==null&&R==null) return true;
        if (L==null||R==null||L.val!=R.val) return false;
        return cur(L.left, R.right) && cur(L.right, R.left);
    }
}
