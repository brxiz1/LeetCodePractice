public class T124 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode left=new TreeNode(2);
        TreeNode right=new TreeNode(3);
        root.left=left;
        root.right=right;
        Solution124 s124=new Solution124();
        System.out.println(s124.maxPathSum(root));

    }
}

class Solution124 {
    public int maxPathSum(TreeNode root) {

        int[] max=new int[]{root.val};
        maxPath(root,max);
        return max[0];
    }
    public int maxPath(TreeNode root,int[] max){
        if(root==null) return 0;
        int left= maxPath(root.left,max)+root.val;
        int right=maxPath(root.right,max)+root.val;
        if(left>0&&right>0){
            max[0]=Math.max(max[0],Math.max(left+right- root.val,Math.max(left,right)));
            return Math.max(left,right);
        }else{
            max[0]=Math.max(max[0],left+right-root.val);
            return Math.max(0,Math.max(left,right));
        }
    }
}
