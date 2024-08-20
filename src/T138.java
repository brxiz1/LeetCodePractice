import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangYihe
 * @since 2024/8/20
 **/
public class T138 {

}
class Solution138{
    public Node copyRandomList(Node head) {
        Map<Node,Integer> map=new HashMap<>();
        List<Node> list=new ArrayList<>();
        Node check=head;
        Node res=new Node(0);
        Node resCheck=res;
        int index=0;
        while(check!=null){
            resCheck.next=new Node(check.val);
            map.put(check,index++);

            check=check.next;
            resCheck=resCheck.next;

            list.add(resCheck);
        }
        check=head;
        resCheck=res.next;
        while(check!=null){
            int i=map.getOrDefault(check.random,-1);
            if(i==-1){
                resCheck.random=null;
            }else{
                resCheck.random=list.get(i);
            }

            check=check.next;
            resCheck=resCheck.next;
        }
        return res.next;
    }
    class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}