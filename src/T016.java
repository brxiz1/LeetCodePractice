import java.util.Arrays;

/**
 * @author ZhangYihe
 * @since 2024/12/29
 **/
public class T016 {
}

class Solution016{
    public int threeSumClosest(int[] nums, int target) {
        int length=nums.length;
        int closestSum=Integer.MAX_VALUE;
        Arrays.sort(nums);
        //双指针法遍历,进一步缩小了范围
        for(int i=0;i<length-2;i++){
            int left=i+1;
            int right=length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                closestSum=Math.abs(target-closestSum)>Math.abs(target-sum)?sum:closestSum;

                if( sum==target)return sum;
                else if(sum>target)right--;
                else left++;
            }
        }
        return closestSum;
    }
}