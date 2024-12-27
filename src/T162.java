/**
 * @author ZhangYihe
 * @since 2024/12/26
 **/
public class T162 {
}

class Solution162{
    public int findPeakElement(int[] nums) {
        int length= nums.length;
        int l=0;
        int r=length-1;
        int mid=0;
        if(length==1)return 0;
        while(l<r){
            mid=(l+r)/2;
            if(mid-1<0||mid+1>length){
                break;
            }

            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
                return mid;
            }

            if(nums[mid+1]>nums[mid]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        if(l==r)return l;
        if(nums[mid]>nums[mid+1]){
            return mid;
        }else{
            return mid+1;
        }
    }
}