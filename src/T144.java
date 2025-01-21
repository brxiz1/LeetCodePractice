import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/20
 **/
public class T144 {
}

class Solution144{
    List<Integer> resList=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        search(root);
        return resList;
    }
    public void search(TreeNode root){
        if(root==null)return;
        resList.add(root.val);
        search(root.left);
        search(root.right);
    }
}
