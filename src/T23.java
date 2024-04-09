import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T23 {
    public static void main(String[] args) {
        Solution23 s23=new Solution23();
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(5);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);
        ListNode l3=new ListNode(2);
        l3.next=new ListNode(6);
        ListNode[] ls=new ListNode[]{l1,l2,l3};
        ListNode res=s23.mergeKLists(ls);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q=new PriorityQueue<>(Comparator.comparingInt((ListNode l) -> l.val));
        for(ListNode l :lists){
            if(l!=null){
                q.add(l);
            }
        }
        ListNode head=new ListNode();
        ListNode t=head;
        boolean isChanged=false;
        while(true){
            t.next=q.poll();
//            System.out.println(t.val);
            if(t.next==null){
                break;
            }
            t=t.next;
            if(t.next!=null){
                q.add(t.next);
            }
        }
        return head.next;
    }
}