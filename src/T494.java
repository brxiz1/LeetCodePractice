public class T494 {
}
class Solution494{
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        int div=sum-target;
        if(div%2==1||div<0){
            return 0;
        }
        div/=2;
        int length=nums.length;
        int[] dp=new int[div+1];
        if(nums[0]<=div)dp[nums[0]]=1;
        dp[0]+=1;
        for(int i=1;i<length;i++){
            int n=nums[i];
            for(int j=div;j>=0;j--){
                if(n<=j){
                    dp[j]=dp[j]+dp[j-n];
                }
            }
        }
        return dp[div];
    }
}