package question2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class question2 {
    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> children1 = new ArrayList<>();
        children1.add(node5);
        children1.add(node6);
        Node node3 = new Node(3, children1);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        List<Node> children2 = new ArrayList<>();
        children2.add(node2);
        children2.add(node3);
        children2.add(node4);
        Node node1 = new Node(1, children2);
        question2 question2 = new question2();
        question2.postorder(node1);

    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postOrder(list, root);
        return list;
    }

    public void postOrder(List<Integer> list, Node root) {
        if (root == null) return;
        for (Node node : root.children)
            postOrder(list, node);
        list.add(root.val);
    }
}

