/**
 * @author ZhangYihe
 * @since 2024/8/20
 **/
public class T025 {
}
class Solution25{
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevHead=new ListNode();
        prevHead.next=head;

        ListNode check=head;
//        ListNode tail;
        ListNode h=prevHead;
        int count=0;
        while(true){
            if(count==k){
                h=reverse(h,check);
                count=0;
            }
            count++;
            if(check==null) break;
            check=check.next;
        }
        return prevHead.next;
    }

    public ListNode reverse(ListNode prevHead,ListNode tail){
        ListNode prev;
        ListNode now=prevHead;
        ListNode last=prevHead.next;
        while(last!=tail){
            prev=now;
            now=last;
            last=now.next;

            now.next=prev;
        }
        ListNode res=prevHead.next;
        prevHead.next.next=tail;
        prevHead.next=now;
        return res;
    }
}