package question2;

import java.util.ArrayList;
import java.util.List;

public class question3 {
    public static void main(String[] args) {

    }
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preOrder(list, root);
        return list;
    }

    private void preOrder(List<Integer> list, Node root) {
        if (root==null){
            return;
        }
        list.add(root.val);
        for (Node node:root.children){
            preOrder(list, node);
        }
    }
}
