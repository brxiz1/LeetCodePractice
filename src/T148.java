public class T148 {
    public static void main(String[] args) {
        ListNode head=new ListNode(4);
        ListNode h2=new ListNode(2);
        ListNode h3=new ListNode(1);
        ListNode h4=new ListNode(3);
        head.next=h2;
        h2.next=h3;
        h3.next=h4;
        Solution148 s148=new Solution148();
        head=s148.sortList(head);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}

class Solution148{
    public ListNode sortList(ListNode head) {
        int length=0;
        ListNode nullHead=new ListNode();
        nullHead.next=head;
        ListNode newHead=head;
        while(newHead!=null){
            length++;
            newHead=newHead.next;
        }
        if(length<=1){
            return head;
        }
//        int nowLength=1;
//        newHead=head;
//        for(int i=2;i<length;i*=2){
//            for(int j=0;j<length/i;j++){
//
//            }
//        }
        int nowLength=1;
        for(;nowLength<length;nowLength<<=1){
            ListNode prevHead1=nullHead;
            ListNode head1=prevHead1.next;
            ListNode head2=null;
            ListNode corr=head1;
//            for(int i=0;i<nowLength;i++){
//                head2=head2.next;
//            }
            while(corr!=null){
                //排序后，可能导致head1的值变化，需要调整前一位节点的next指向
                head1=corr;
//                corr=head1;
                for(int i=1;i<nowLength&&corr.next!=null;i++){
                    corr=corr.next;
                }
//                if(corr.next!=null){
//                    head2=corr.next;
//                    corr.next=null;
//                }else{
//                    prevHead1.next=head1;
//                    break;
//                }
                head2=corr.next;
                corr.next=null;
                corr=head2;
                for(int i=1;i<nowLength&&corr!=null&&corr.next!=null;i++){
                    corr=corr.next;
                }
                ListNode next=null;
                if(corr!=null){
                    next=corr.next;//记录本段排序之后的下一个head
                    corr.next=null;
                }


                head1=twoListSort(head1,head2,nowLength);

                prevHead1.next=head1;
                while (prevHead1.next != null) {
                    prevHead1 = prevHead1.next;
                }
                corr=next;

            }
        }
        return nullHead.next;
    }
    public ListNode twoListSort(ListNode head1,ListNode head2,int length){
        ListNode resHead=new ListNode();

        ListNode checkHead=resHead;
        ListNode check1=head1;
        ListNode check2=head2;
//        int length1=0;
//        int length2=0;
        while(check1!=null&&check2!=null){
            if(check1.val<check2.val){
                checkHead.next=check1;
                check1=check1.next;
            }else{
                checkHead.next=check2;
                check2=check2.next;
            }
            checkHead=checkHead.next;
        }
        if(check1==null)checkHead.next=check2;
        else{
            checkHead.next=check1;
            //这可能导致成环，因为head1和head2本就在一条链表中，为此应将head1和head2截取下来后再排序
        }
        return resHead.next;


    }
}