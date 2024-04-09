import java.util.Arrays;

public class T53 {
    public static void main(String[] args) {
        Solution53 s53=new Solution53();
        System.out.println(s53.maxSubArray(new int[]{1}));
    }
}
class Solution53 {
    //对数组问题做动态规划解时，考虑将子问题定为“以i为尾的数组满足条件”可以有效保证无后效性
    public int maxSubArray(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==0){
                continue;
            }else{
                nums[i]=Math.max(nums[i],nums[i]+nums[i-1]);
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}
