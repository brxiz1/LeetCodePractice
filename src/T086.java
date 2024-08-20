/**
 * @author ZhangYihe
 * @since 2024/8/20
 **/
public class T086 {
}
class Solution86{
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode();
        ListNode largeAndEqual=new ListNode();
        ListNode sCheck=small;
        ListNode lCheck=largeAndEqual;
        while(head!=null){
            if(head.val<x){
                sCheck.next=head;
                sCheck=sCheck.next;


            }else{
                lCheck.next=head;
                lCheck=lCheck.next;

            }
            head=head.next;
        }
        lCheck.next=null;
        sCheck.next=largeAndEqual.next;
        return small.next;
    }
}