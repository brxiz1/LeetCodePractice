public class T114 {
}
//****本题值得多看
class Solution114 {
    public void flatten(TreeNode root) {
        if(root==null) return;
        change(root);
    }
    public TreeNode change(TreeNode root){
        if(root.left==null&&root.right==null) return root;
        if(root.left==null) return change(root.right);
        if(root.right==null){
            root.right=root.left;
            root.left=null;
            return change(root.right);
        }else{
            TreeNode finalLeft=change(root.left);
            finalLeft.right=root.right;
            root.right=root.left;
            root.left=null;
            return change(finalLeft.right);
        }
    }
}