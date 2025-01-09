/**
 * @author ZhangYihe
 * @since 2025/1/8
 **/
public class T081 {
    public static void main(String[] args) {
        Solution81 solution81=new Solution81();
        boolean res=solution81.search(new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1},13);
        System.out.println(res);
    }
}

class Solution81{
    public boolean search(int[] nums, int target) {
        int length=nums.length;
        int l=0;
        int r=length-1;
        while(l<r){
            int mid=(l+r)/2;
            //考虑重复情况

            if(nums[mid]==nums[l]&&nums[mid]==nums[r]){
                l+=1;
                r-=1;

            }else if(nums[mid]<=nums[r]){//如果mid->r为有序区间,
                if(target==nums[mid]||target==nums[r])return true;
                if(target>nums[mid]&&target<nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }else if(nums[l]<=nums[mid]){//如果l->mid为有序区间，
                if(target==nums[l]||target==nums[mid])return true;
                if(target>nums[l]&&target<nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }

        }
        return nums[l]==target;
    }
}