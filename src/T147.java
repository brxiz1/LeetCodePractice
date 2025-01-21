/**
 * @author ZhangYihe
 * @since 2025/1/20
 **/
public class T147 {
    public static void main(String[] args) {
        Solution147 solution147=new Solution147();
        ListNode n1=new ListNode(-1);
        ListNode n2=new ListNode(5);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(0);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        ListNode res=solution147.insertionSortList(n1);
    }
}
class Solution147{
    public ListNode insertionSortList(ListNode head) {
        ListNode check=head;
        ListNode nullHead=new ListNode();
//        nullHead.next=head;
        while(check!=null){
            ListNode frontCheck=nullHead;
            while(frontCheck.next!=null&&frontCheck.next.val<check.val){
                frontCheck=frontCheck.next;
            }
//            if(frontCheck.next==null){
//                ListNode next=check.next;
//                //插入，注意要断开有序前缀和无序后缀之间的连接，不然会成环
//                check.next=null;
//                check=next;
//                continue;
//            }
            ListNode next=check.next;

            check.next=frontCheck.next;
            frontCheck.next=check;

            check=next;

        }
        return nullHead.next;
    }
}
