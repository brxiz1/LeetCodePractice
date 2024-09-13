/**
 * @author ZhangYihe
 * @since 2024/8/28
 **/
public class T530 {
}
class Solution530{
    int min=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        int prev=-100000;
        search(root,prev);
        return min;
    }
    public int search(TreeNode root,int prev){
//        int n=root.val>prev?root.val-prev:prev-root.val;
        int pl=-1;
        if(root.left!=null){
            pl=search(root.left,prev);
        }

        int n=Integer.MAX_VALUE;
        if(pl>=0){
            n=root.val-pl;
        }else{
            n=root.val-prev;
        }
        int pr=root.val;
        if(root.right!=null){
            pr=search(root.right,root.val);
        }
//        n=Math.min(n,root.val-pr);
        if(n<min){
            min=n;
        }
        return pr;
    }
}