public class T236 {
}
class Solution236{
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isFind(root,p,q);
        return res;
    }

    public boolean isFind(TreeNode root,TreeNode p,TreeNode q){
        if(res!=null||root==null)return false;
        boolean l=isFind(root.left,p,q);
        boolean r=isFind(root.right,p,q);
        if(l&&r||(l||r)&&(root.val==p.val||root.val==q.val)){
            res=root;
        }
        return l||r||root.val==p.val||root.val==q.val;
    }
}