public class T226 {
}

class Solution226{
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode n=root.left;
        root.left=root.right;
        root.right=n;
        invert(root.left);
        invert(root.right);

    }
}