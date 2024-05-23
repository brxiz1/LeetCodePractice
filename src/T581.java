public class T581 {
}
class Solution581{
    public int findUnsortedSubarray(int[] nums) {
        int right=-1;
        int max=Integer.MIN_VALUE;
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]<max){
                right=i;
            }else{
                max=nums[i];
            }
        }
        int left=-1;
        int min=Integer.MAX_VALUE;
        for(int i=length-1;i>=0;i--){
            if(nums[i]>min){
                left=i;
            }else{
                min=nums[i];
            }
        }
        if(left==-1&&right==-1) return 0;
        return right-left+1;
    }
}
