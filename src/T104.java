public class T104 {

}
class Solution104 {
    public int maxDepth(TreeNode root) {
        return dPS(root);
    }
    public int dPS(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftDeep=dPS(root.left);
        int rightDeep=dPS(root.right);
        return 1+Math.max(leftDeep,rightDeep);
    }
}
