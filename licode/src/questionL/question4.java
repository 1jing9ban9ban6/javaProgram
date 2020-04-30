package questionL;


public class question4 {
    public static void main(String[] args) {
//        给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。
//        已知此链表是一个整数数字的二进制表示形式。
//        请你返回该链表所表示数字的 十进制值 。
//        输入：head = [1,0,1]
//        输出：5q
//        解释：二进制数 (101) 转化为十进制数 (5)
        ListNode head = new ListNode(1);
        StringBuffer str = new StringBuffer();
        while (head!=null){
            str = str.append(head.val);
            head = head.next;
        }
        System.out.println(Integer.parseInt(str.toString(), 2));
    }
}
