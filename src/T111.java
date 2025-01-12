/**
 * @author ZhangYihe
 * @since 2025/1/12
 **/
public class T111 {
}

class Solution111{
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        int lh=minDepth(root.left);
        int rh=minDepth(root.right);
        if(lh==0){
            return rh+1;
        }else if(rh==0){
            return lh+1;
        }else{
            return Math.min(lh,rh)+1;
        }
    }
}