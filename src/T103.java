import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2024/8/27
 **/
public class T103 {
    public static void main(String[] args) {
        Solution103 s103=new Solution103();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t4.right=t5;
        List<List<Integer>> lli=s103.zigzagLevelOrder(t1);
        System.out.println(lli);
    }
}
class Solution103{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque=new LinkedList<>();
        deque.addFirst(root);
        List<List<Integer>> lli=new ArrayList<>();
        boolean r=false;
        while(!deque.isEmpty()){
            int size=deque.size();
            List<Integer> li=new ArrayList<>();
            for(int i=0;i<size;i++){

                if(r){
                    //注意Deque的get方法不会从队列中移除node
                    TreeNode t=deque.getLast();
                    deque.removeLast();
                    if(t==null)continue;
                    li.add(t.val);
                    deque.addFirst(t.right);
                    deque.addFirst(t.left);

                }else{
                    TreeNode t=deque.getFirst();
                    deque.removeFirst();
                    if(t==null)continue;
                    li.add(t.val);
                    deque.addLast(t.left);
                    deque.addLast(t.right);
                }
            }
            if(!li.isEmpty()){
                lli.add(li);
            }

            r=!r;
        }
        return lli;
    }
}