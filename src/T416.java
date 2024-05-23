public class T416 {
    public static void main(String[] args) {
        Solution416 s416=new Solution416();
        int[] example=new int[]{3,3,3,4,5};
        boolean res=s416.canPartition(example);
        System.out.println(res);
    }
}
//背包问题的范例
class Solution416{
    public boolean canPartition(int[] nums) {
        int sum=0;
        int max=0;
        int length=nums.length;
        for(int n:nums){
            sum+=n;
            max=Math.max(max,n);
        }
        if(nums.length<=1||sum%2==1||max*2>sum){
            return false;
        }

        boolean[][] dp=new boolean[length][sum/2+1];

        for(boolean[] bs:dp){
            for(boolean b:bs){
                b=false;
            }
        }
        for(int i=0;i<length;i++){
            dp[i][0]=true;
        }
        dp[0][nums[0]]=true;
        for(int i=1;i<length;i++){
            for(int j=1;j<=sum/2;j++){
                if(nums[i]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]];
                }
            }
        }
        boolean res=false;
        for(int i=0;i<length;i++){
            res|=dp[i][sum/2];
        }
        return res;
    }
}