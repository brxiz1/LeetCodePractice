import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/20
 **/
public class T143 {
    public static void main(String[] args) {
        Solution143 solution143=new Solution143();
        ListNode h1=new ListNode(1);
        ListNode h2=new ListNode(2);
        ListNode h3=new ListNode(3);
        ListNode h4=new ListNode(4);
        h1.next=h2;
        h2.next=h3;
        h3.next=h4;
        solution143.reorderList(h1);
    }
}

class Solution143{
    public void reorderList(ListNode head) {
        //要提前处理head.next==null的情况
        if(head.next==null)return;
        ListNode midNode=findMidPoint(head);
        for(ListNode check=head;check.next!=null;check=check.next){
            if(check.next==midNode){
                check.next=null;
                break;
            }
        }
        ListNode h2=reverseListNode(midNode);
        ListNode res=listNodeMerge(head,h2);

    }

    //寻找链表中点
    public ListNode findMidPoint(ListNode head){
        ListNode checkSlow=head;
        ListNode checkFast=head;
        while(checkFast!=null){
            checkFast=checkFast.next;
            if(checkFast==null)return checkSlow;
            checkFast=checkFast.next;
            checkSlow=checkSlow.next;
        }
        return checkSlow;
    }

    public ListNode reverseListNode(ListNode head){
        ListNode nullHead=new ListNode();

        ListNode prev=null;
        ListNode now=head;
        ListNode next=head.next;
        while(now!=null){
            next=now.next;
            now.next=prev;
            prev=now;
            now=next;
        }
        return prev;
    }

    public ListNode  listNodeMerge(ListNode h1,ListNode h2){
        ListNode nullHead=new ListNode();
        ListNode check=nullHead;
        while(h1!=null&&h2!=null){
            check.next=h1;
            h1=h1.next;
            check=check.next;

            check.next=h2;
            h2=h2.next;
            check=check.next;
        }
        if(h1==null)check.next=h2;
        else check.next=h1;
        return nullHead.next;
    }
}