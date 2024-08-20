/**
 * @author ZhangYihe
 * @since 2024/8/20
 **/
public class T082 {

}
class Solution082{
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prevHead=new ListNode(-300);
        prevHead.next=head;
        ListNode prev=prevHead;
        ListNode now=head;
        while(now!=null){
            if(now.next==null||now.next.val!=now.val){
                prev=now;
                now=now.next;
            }else{
                deleteNode(prev,now);
                now=prev.next;
            }
        }
        return prevHead.next;
    }
    public  void deleteNode(ListNode prev,ListNode tobeDel){
        ListNode check=tobeDel.next;
        while(true){
            if(check==null||check.val!= tobeDel.val){
                prev.next=check;
                break;
            }else{
                check=check.next;
            }
        }

    }
}