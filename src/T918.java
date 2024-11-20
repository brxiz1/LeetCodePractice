/**
 * @author ZhangYihe
 * @since 2024/10/31
 **/
public class T918 {
    public static void main(String[] args) {
        Solution918 s918=new Solution918();
        int res=s918.maxSubarraySumCircular(new int[]{1,-2,3,-2});
        System.out.println(res);
    }
}
class Solution918{
    public int maxSubarraySumCircular(int[] nums) {
        int length=nums.length;
        if(length==1)return nums[0];
        int[] sumMax=new int[nums.length];//正序，最后一位为i的最大前缀和(必须包含i，不一定包含i前面的数)
        int[] leftMax=new int[length];//正序，从0开始至i之间能取到的最大前缀和（必须包含0，不一定包含0之后的值）
        int[] tailSum=new int[nums.length];
        int[] leftSum=new int[length];//前缀和
        int maxSum=Integer.MIN_VALUE;

        leftMax[0]=nums[0];
        tailSum[nums.length-1]=nums[nums.length-1];
        sumMax[0]=nums[0];
        leftSum[0]=nums[0];
        //动态规划迭代公式：
        //  sumMax[i]=Math.max(sumMax[i-1]+nums[i],nums[i])
        //  leftMax[i]=Math.max(leftMax[i-1],leftSum[i-1]+nums[i])
        //  tailSum[i]=tailSum[i+1]+nums[i]
        for(int i=1;i<length;i++){
//            prevSum[i]=headSum[i-1]+nums[i];
            tailSum[length-1-i]=tailSum[length-i]+nums[length-1-i];
            leftSum[i]=leftSum[i-1]+nums[i];
            leftMax[i]=Math.max(leftSum[i],leftMax[i-1]);
            sumMax[i]=Math.max(sumMax[i-1]+nums[i],nums[i]);

        }
        for(int i=1;i<length;i++){
            maxSum=Math.max(maxSum,tailSum[i]+leftMax[i-1]);
        }
        for(int i=0;i<length;i++){
            maxSum=Math.max(maxSum,sumMax[i]);
        }
        return maxSum;
    }
}