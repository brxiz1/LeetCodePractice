/**
 * @author ZhangYihe
 * @since 2025/2/3
 **/
public class T235 {
}

class Solution235{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return search(root,p,q);
    }
    public TreeNode search(TreeNode root, TreeNode p, TreeNode q){
        if(root.val<p.val&&root.val<q.val){
            return search(root.right,p,q);
        }else if(root.val>p.val&&root.val>q.val){
            return search(root.left,p,q);
        }else{
            return root;
        }
    }
}