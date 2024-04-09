public class T198 {
}

class Solution198{
    public int rob(int[] nums) {
        int length=nums.length;
        int[] reward=new int[length];
        if(length==1) return nums[0];
        reward[0]=nums[0];
        reward[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<length;i++){
            reward[i]=Math.max(reward[i-1],reward[i-2]+nums[i]);
        }
        return reward[length-1];
    }
}