/**
 * @author ZhangYihe
 * @since 2024/8/21
 **/
public class T112 {
}
class Solution112{
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        return sumDps(root,targetSum,0);
    }
    public boolean sumDps(TreeNode root,int targetSum,int nowSum){
        if(root==null)return false;
        if(root.left==null&&root.right==null)return nowSum+root.val==targetSum;

        boolean left=sumDps(root.left,targetSum,nowSum+root.val);

        boolean right=sumDps(root.right,targetSum,nowSum+root.val);
        return left||right;
    }
}