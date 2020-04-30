package questionL;

/**
 * @author jing
 * @create 2020-03-25-11:13
 */
public class LinkList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode1 deleteNode(ListNode1 head, int val) {
            if (head.val==val){
                return head.next;
            }
            ListNode1 pre = head;
            ListNode1 last = head.next;
            while (last!=null){
                if (last.val==val){
                    pre.next = last.next;
                    return head;
                }
                pre = pre.next;
                last = last.next;
            }
            return head;
        }
    }
    public ListNode1 getKthFromEnd(ListNode1 head, int k) {
        ListNode1 flag = head;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        while (head!=null){
            flag = flag.next;
            head = head.next;
        }
        return flag;
    }
    public ListNode1 reverseList(ListNode1 head) {
        if (head.next==null) return head;
        if (head.next.next==null) {
            ListNode1 p = head.next;
            p.next = head;
            return p;
        }
        ListNode1 q = head.next;
        ListNode1 r = q.next;
        while (q != null){
            q.next = head;
            head = q;
            q = r;
            r = r.next;

        }
        return q;
    }
    public ListNode1 mergeTwoLists(ListNode1 l1, ListNode1 l2) {
        ListNode1 p = new ListNode1(0);
        while (l1!=null && l2!=null){
            if (l1.val<=l2.val){
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null){
            p.next = l2;
        } else {
            p.next = l1;
        }
        return p.next;
    }
}
class ListNode1{
    int val;
    ListNode1 next;
    ListNode1(int x) { val = x; }
}
