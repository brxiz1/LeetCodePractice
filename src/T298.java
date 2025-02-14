/**
 * @author ZhangYihe
 * @since 2025/2/14
 **/
public class T298 {
}

class Solution298{
    int maxLength=0;
    public int longestConsecutive(TreeNode root) {
        dps(root.left,root.val,1);
        dps(root.right,root.val,1);
        return maxLength;
    }
    public void dps(TreeNode root,int prevVal,int nowLength){
        if(root==null){
            maxLength=Math.max(maxLength,nowLength);
            return;
        }

        if(root.val==prevVal+1){
            nowLength++;
        }else{
            maxLength=Math.max(maxLength,nowLength);
            nowLength=1;
        }
        dps(root.left,root.val,nowLength);
        dps(root.right,root.val,nowLength);
    }

}