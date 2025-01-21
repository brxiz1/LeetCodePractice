import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/20
 **/
public class T145 {
}

class Solution145{
    List<Integer> list=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        search(root);
        return list;
    }
    public void search(TreeNode root){
        if(root==null)return;
        search(root.left);
        search(root.right);
        list.add(root.val);
    }
}
