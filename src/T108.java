/**
 * @author ZhangYihe
 * @since 2024/10/31
 **/
public class T108 {

}
class Solution108{
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode n=createBST(nums,0, nums.length-1);
        return n;
    }
    public TreeNode createBST(int[] nums,int left,int right){
        if(left==right)return new TreeNode(nums[left]);
        else if(left>right)return null;
        int mid=(left+right+1)/2;
        TreeNode m=new TreeNode(nums[mid]);
        m.left=createBST(nums,left,mid-1);
        m.right=createBST(nums,mid+1,right);
        return m;
    }
}
