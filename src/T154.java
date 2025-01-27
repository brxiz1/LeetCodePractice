/**
 * @author ZhangYihe
 * @since 2025/1/24
 **/
public class T154 {

}

class Solution154{

    public int findMin(int[] nums) {
        int length=nums.length;
        int l=0;
        int r=length-1;
        while(l<r){
            if(nums[l]==nums[r]){
                l++;
                continue;
            }
            int mid=(l+r)/2;
            if(nums[mid]<=nums[r]){
                r=mid;
            }else if(nums[mid]>=nums[l]){
                l=mid+1;
            }
        }
        return nums[l];
    }


}