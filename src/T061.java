/**
 * @author ZhangYihe
 * @since 2024/8/20
 **/
public class T061 {
}
class Solution61{
    public ListNode rotateRight(ListNode head, int k) {
        ListNode check=head;
        if(head==null||head.next==null)return head;
        int length=1;
        while(check.next!=null){
            check=check.next;
            length++;
        }
        check.next=head;
        k=k%length;
        for(int i=0;i<length-k;i++){
            if(i==length-k-1){
                ListNode res=head.next;
                head.next=null;
                return res;
            }
            head=head.next;
        }
        return head;
    }
}