public class T206 {
}

class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode corr=head;
        if(corr==null||corr.next==null) return corr;
        ListNode next=head.next;
        while(corr.next!=null){
            corr.next=prev;
            prev=corr;
            corr=next;
            next=corr.next;
        }
        corr.next=prev;
        return corr;
    }
}