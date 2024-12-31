/**
 * @author ZhangYihe
 * @since 2024/12/31
 **/
public class T024 {
}
class Solution024{
    public ListNode swapPairs(ListNode head) {
        ListNode prevHead=new ListNode();
        prevHead.next=head;
        ListNode n0=prevHead;
        ListNode n1;
        ListNode n2;
        while(true){
            n1=n0.next;
            if(n1==null)break;
            n2=n1.next;
            if(n2==null)break;
            n1.next=n2.next;
            n0.next=n2;
            n2.next=n1;
            n0=n1;
        }
        return prevHead.next;
    }
}