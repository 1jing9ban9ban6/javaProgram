package question3;

public class question9 {
    public static void main(String[] args) {
        int[] ints = new int[5];
        int[] aa=ints;
        aa[1] = 5;
        if (ints==null){
            System.out.println("kp");
        }
        else {
            System.out.println("ddd");
        }
        TreeNode treeNode = new TreeNode(1);
        System.out.println(aa[1]);
        System.out.println(ints[1]);
    }
}
