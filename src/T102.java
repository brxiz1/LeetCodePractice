import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T102 {
}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<List<Integer>> lli=new ArrayList<>();
        TreeNode t;
        int numsInQ=1;
        while(!q.isEmpty()){
            int j=numsInQ;
            numsInQ=0;
            List<Integer> list=new ArrayList<>();

            while(j>0){
                t=q.poll();
                if(t!=null){
                    list.add(t.val);
                    q.add(t.left);
                    q.add(t.right);
                    numsInQ+=2;
                }
                j--;
            }
            if(!list.isEmpty())lli.add(list);
        }
        return lli;
    }
}