package leeCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jing
 * @create 2020-04-11-21:45
 */
public class copyList {
    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;
        node13.random = node7;
        node10.random = node11;
        node1.random = node7;
        Node node = copyRandomList(node7);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static Node copyRandomList(Node head) {
        Node root = new Node(-1);
        Node index = root;
        Node p = head;
        HashMap<Node, Integer> map = new HashMap<>();
        int i = 0;
        while (head != null) {
            Node node = new Node(head.val);
            index.next = node;
            map.put(head, i);
            head = head.next;
            index = node;
            i++;
        }
        index = root.next;
        while (p != null) {
            Integer integer = map.get(p.random);
            if (integer != null){
                Node q = root.next;
                for (int j = 0; j < integer; j++) {
                    q = q.next;
                }
                index.random = q;
            }
            index = index.next;
            p = p.next;
        }
        return root.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
