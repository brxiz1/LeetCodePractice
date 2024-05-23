public class T538 {

}
class Solution538{
    int res=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode right=convertBST(root.right);

        root.val+=res;
        res=root.val;

        TreeNode left=convertBST(root.left);
        return root;

    }
}
