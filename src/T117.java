import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhangYihe
 * @since 2024/8/21
 **/
public class T117 {

}
class Solution117{
    public Node117 connect(Node117 root) {
        Queue<Node117> queue=new LinkedList<>();
        Node117 head=new Node117();
        queue.add(root);
        while(!queue.isEmpty()){
            Node117 check=head;
            while(!queue.isEmpty()){
                check.next=queue.poll();
                check=check.next;
            }
            check=head.next;
            while(check!=null){
                if(check.left!=null){
                    queue.offer(check.left);
                }
                if(check.right!=null){
                    queue.offer(check.right);
                }
                check=check.next;
            }
        }
        return root;
    }


    class Node117{
        public int val;
        public Node117 left;
        public Node117 right;
        public Node117 next;

        public Node117() {}

        public Node117(int _val) {
            val = _val;
        }

        public Node117(int _val, Node117 _left, Node117 _right, Node117 _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
