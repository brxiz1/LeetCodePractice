import java.util.Stack;

public class T19 {

}
/**
 * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode() {}
// *     ListNode(int val) { this.val = val; }
// *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// * }
 */
 class ListNode19 {
    int val;
    ListNode19 next;
    ListNode19() {}
    ListNode19(int val) { this.val = val; }
    ListNode19(int val, ListNode19 next) { this.val = val; this.next = next; }
}
class Solution19 {
    public ListNode19 removeNthFromEnd(ListNode19 head, int n) {
        Stack<ListNode19> stack=new Stack<>();
        ListNode19 l=head;
        int length=0;
        while(true){
            if(l==null){
                break;
            }
            stack.push(l);
            l=l.next;
            length++;
        }
        if(n==length&&head!=null){
            return head.next;
        }
        for(int i=0;i<n;i++){
            stack.pop();
        }
        ListNode19 nl=stack.pop();
        nl.next=nl.next.next;
        return head;
    }
}
