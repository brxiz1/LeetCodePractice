public class T543 {
}
class Solution543{
    int maxLength=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dps(root);
        return maxLength;
    }
    public int dps(TreeNode root){
        if(root==null)return 0;
        int l=dps(root.left);
        int r=dps(root.right);
        maxLength=Math.max(maxLength,l+r);
        return Math.max(l,r)+1;
    }
}