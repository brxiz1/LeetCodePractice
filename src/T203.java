/**
 * @author ZhangYihe
 * @since 2025/1/31
 **/
public class T203 {
}
class Solution203{
    public ListNode removeElements(ListNode head, int val) {
        ListNode nullHead=new ListNode();
        nullHead.next=head;
        ListNode check=head;
        ListNode prev=nullHead;
        while(check!=null){
            if(check.val==val){
                prev.next=check.next;

            }else{
                prev=check;
            }
            check=check.next;
        }
        return nullHead.next;
    }
}