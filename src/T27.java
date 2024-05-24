public class T27 {

}
class Solution27{
    public int removeElement(int[] nums, int val) {
        int length=nums.length;
        int right=length-1;
        if(length==0)return 0;
        for(int i=0;i<right;i++){
            if(nums[i]==val){
                while(nums[right]==val&&right>i){
                    right--;
                }
                nums[i]=nums[right];
                nums[right]=val;
            }
        }
        if(nums[right]!=val)right++;
        return right;
    }
}