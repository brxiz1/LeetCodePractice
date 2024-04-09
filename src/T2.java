public class T2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(1);
        l1.next.next.next=new ListNode(1);
        ListNode l2=new ListNode(9);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        Solution2 s=new Solution2();
        ListNode res=s.addTwoNumbers(l1,l2);
        while(res!=null){
            System.out.print(res.val);
            res=res.next;
        }
    }

}
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up=0;
        ListNode t= new ListNode(0);
        ListNode n=t;
        while(true){
            int i1;
            int i2;
            if(l1==null){
                i1=0;
            }else{
                i1=l1.val;
                l1=l1.next;
            }
            if(l2==null){
                i2=0;
            }else{
                i2=l2.val;
                l2=l2.next;
            }
            n.next= new ListNode((i1 + i2 + up) % 10);
            up=(i1+i2+up)/10;
            n=n.next;
            if(l1==null&&l2==null){
                if(up==1) n.next=new ListNode(1);
                break;
            }
        }
        return t.next;

    }
}
