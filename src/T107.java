import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ZhangYihe
 * @since 2025/1/12
 **/
public class T107 {

}
class Solution107{
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        List<List<Integer>> lli=new LinkedList<>();
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList<>();
            for(;size>0;size--){
                TreeNode n=q.poll();
                if(n!=null){
                    list.add(n.val);
                    q.offer(n.left);
                    q.offer(n.right);
                }

            }
            if(!list.isEmpty()) lli.addFirst(list);

        }
        return lli;
    }
}