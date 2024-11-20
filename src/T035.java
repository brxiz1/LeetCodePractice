/**
 * @author ZhangYihe
 * @since 2024/11/20
 **/
public class T035 {
    public static void main(String[] args) {
        Solution35 s35=new Solution35();
        int res=s35.searchInsert(new int[]{1},1);
        System.out.println(res);
    }
}
class Solution35{
    public int searchInsert(int[] nums, int target) {
        int length= nums.length;
        int l=0;
        int r=length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        if(nums[r]>=target)return r;
//        else if(nums[r]==target)return r;
        else return r+1;
    }
}