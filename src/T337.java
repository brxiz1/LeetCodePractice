import java.util.HashMap;
import java.util.Map;

public class T337 {
}
class Solution337{
    Map<TreeNode,Integer> map=new HashMap<>();
    public int rob(TreeNode root) {
        int[] value=search(root);
        return Math.max(value[0],value[1]);
    }
    public int[] search(TreeNode tree){
        if(tree==null){
            return new int[]{0,0};
        }
        int[] leftValue=search(tree.left);
        int[] rightValue=search(tree.right);
        int[] value=new int[2];
        //0偷，1不偷
        value[0]=tree.val+leftValue[1]+rightValue[1];
        value[1]=Math.max(leftValue[0],leftValue[1])+Math.max(rightValue[0],rightValue[1]);
        return value;
    }
}