public class T26 {
}
class Solution26{
    public int removeDuplicates(int[] nums) {
        int length=nums.length;
        int quick=1;
        int slow=0;
        for(;slow<length;slow++){
            while(quick<length&&nums[quick]==nums[slow]){
                quick++;
            }
            if(quick==length) break;
            nums[slow+1]=nums[quick];
        }
        return slow+1;
    }
}