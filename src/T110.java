/**
 * @author ZhangYihe
 * @since 2025/1/12
 **/
public class T110 {
}

class Solution110{
    public boolean isBalanced(TreeNode root) {
        int res=getHeight(root);
        return res!=-1;
    }
    public int getHeight(TreeNode root){
        if(root==null)return 0;
        int lh=getHeight(root.left);
        int rh=getHeight(root.right);
        if(lh==-1||rh==-1||Math.abs(lh-rh)>1)return -1;
        return Math.max(lh,rh)+1;

    }
}