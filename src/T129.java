/**
 * @author ZhangYihe
 * @since 2024/8/23
 **/
public class T129 {

}
class Solution129{
    int sum=0;
    public int sumNumbers(TreeNode root) {
        sum(root,0);
        return sum;
    }
    public void sum(TreeNode root,int val){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            sum+=root.val+val*10;
            return;
        }
        sum(root.left,root.val+val*10);
        sum(root.right,root.val+val*10);
    }
}