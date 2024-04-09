import java.util.LinkedList;
import java.util.Queue;

public class T101 {
}
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode t1=q.poll();
            TreeNode t2=q.poll();
            if(t1==null||t2==null){
                if(t1==t2)continue;
                else return false;
            }
            if(t1.val==t2.val){
                q.add(t1.left);
                q.add(t2.right);
                q.add(t1.right);
                q.add(t2.left);
            }else{
                return false;
            }
        }
        return true;
    }

}