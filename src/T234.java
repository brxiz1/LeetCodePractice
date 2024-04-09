public class T234 {
}
class Solution234{
    public boolean isPalindrome(ListNode head) {
        //快慢指针法迅速找到链表中点
        if(head==null||head.next==null){
            return true;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(true){
            fast=fast.next;
            if(fast==null){
                break;
            }
            fast=fast.next;

            slow=slow.next;
            if(fast==null){
                break;
            }
        }
        ListNode midheadNew=reverseLinkedList(slow);
        while(midheadNew!=null&&head!=midheadNew){
            if(midheadNew.val!=head.val){
                return false;
            }
            head=head.next;
            midheadNew=midheadNew.next;
        }
        return true;
    }
    public ListNode reverseLinkedList(ListNode head){
        ListNode prev=null;
        ListNode now=head;
        ListNode next=null;
        while(now!=null){
            next=now.next;
            now.next=prev;
            prev=now;
            now=next;
        }
        return prev;
    }
}
