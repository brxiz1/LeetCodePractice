import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ZhangYihe
 * @since 2024/8/27
 **/
public class T637 {
}
class Solution637{
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue.offer(root);
        List<Double> res=new ArrayList<>();
        while(!queue.isEmpty()){
            double sum=0;
            double num=0;
            while(!queue.isEmpty()){
                TreeNode t1=queue.poll();
                sum+=t1.val;
                num++;
                queue2.offer(t1);
            }
            res.add(sum/num);
            while(!queue2.isEmpty()){
                TreeNode t1=queue2.poll();
                if(t1.left!=null){
                    queue.offer(t1.left);
                }
                if(t1.right!=null){
                    queue.offer(t1.right);
                }
            }
        }
        return res;
    }
}