public class T80 {
}
class Solution80{
    public int removeDuplicates(int[] nums) {
        int slow=1;
        int fast=2;
        int length=nums.length;
        if(length<3)return length;
        for(;fast<length;fast++){
            if(nums[fast]!=nums[slow-1]){
                slow++;
                nums[slow]=nums[fast];
            }
        }
        return slow+1;
    }
}