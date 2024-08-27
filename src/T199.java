import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2024/8/27
 **/
public class T199 {

}
class Solution199{
    int deepth=0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dps(root,list,1);
        return list;
    }
    public void dps(TreeNode root,List<Integer> list ,int deepthNow){
        if(root==null){
            return;
        }
        if(deepthNow>deepth){
            list.add(root.val);
            deepth++;
        }
        dps(root.right,list,deepthNow+1);
        dps(root.left,list,deepthNow+1);
    }
}