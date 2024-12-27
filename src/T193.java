/**
 * @author ZhangYihe
 * @since 2024/12/26
 **/
public class T193 {
}

class Solution193{
    public int findMin(int[] nums) {
        int length=nums.length;
        int l=0;
        int r=length-1;
        int m=0;
        while(l<r){
            m=(l+r)/2;
            if(nums[m]<nums[r]){
                r=m;
            }else{
                l=m+1;
            }
        }
        return nums[l];
    }
}