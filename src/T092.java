/**
 * @author ZhangYihe
 * @since 2024/8/20
 **/
public class T092 {

}
class Solution92{
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode prevHead=new ListNode();
        prevHead.next=head;
        ListNode before=prevHead;
        ListNode prev;
        ListNode now=prevHead;
        ListNode next=head;
        int index=0;
        ListNode check=head;
        if(left==right){
            return head;
        }
        while(check!=null){
            if(index+2==left){
                before=check;
                now=check;
                next=check.next;

            }else if(index==right||next==null){
               before.next.next=next;
               before.next=now;
               break;
            }else if(index>left-2&&index<right){
                prev=now;
                now=next;
                //now是空值吗？
                next=now.next;

                now.next=prev;
            }else{
                check=check.next;
            }
            index++;
//            if(next==now){
//
//            }
        }
        return prevHead.next;
    }

}