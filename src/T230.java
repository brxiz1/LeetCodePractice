import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYihe
 * @since 2024/8/28
 **/
public class T230 {
    public static void main(String[] args) {
        Solution230 s230=new Solution230();
        TreeNode r1=new TreeNode(3);
        TreeNode r2=new TreeNode(1);

    }
}
class Solution230{
    Map<TreeNode,Integer> countMap=new HashMap<>();
    public int kthSmallest(TreeNode root, int k) {
        count(root);
        countMap.put(null,-1);
        return search(root,k).val;
    }
    public TreeNode search(TreeNode root,int k){
        if(root==null) return null;
        if(countMap.get(root.left)>k-2){
            return search(root.left,k);
        }else if(countMap.get(root.left)==k-2){
            return root;
        }else{
            return search(root.right,k-countMap.get(root.left)-2);
        }
    }

    public int count(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=count(root.left);
        int r=count(root.right);
        countMap.put(root,l+r);
        return l+r+1;
    }
}