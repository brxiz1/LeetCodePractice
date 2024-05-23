public class T437 {
    public static void main(String[] args) {
        Solution437 s437=new Solution437();
        TreeNode root=new TreeNode(0);
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(1);
        root.left=t1;
        root.right=t2;
        int res=s437.pathSum(root,1);
        System.out.println(res);
    }
}
class Solution437{
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        long[] sum=new long[1001];
//        sum[0]=root.val;
        int res=dps(root,sum,targetSum,0);
//        res+=dps(root.right,sum,targetSum,1);
        return res;
    }
    int dps(TreeNode root,long[] sum,int target,int index){
        if(root==null) return 0;
        int res=0;
        if(index!=0){
            sum[index]=root.val+sum[index-1];
        }else{
            sum[index]=root.val;
        }
        if(sum[index]==target){
            res++;
        }
        for(int i=0;i<index;i++){
            if(sum[i]+target==sum[index]){
                    res++;
            }
        }
        if(index>=1000) System.out.println(index+" "+root.val);
        res+=dps(root.left,sum,target,index+1);
        res+=dps(root.right,sum,target,index+1);
        return res;
    }
}
