public class T55 {
    public static void main(String[] args) {

    }
}
class Solution55{
    public boolean canJump(int[] nums) {
        int nearestjump=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]+i>=nearestjump){
                nearestjump=i;
            }
        }
        return nearestjump == 0;
    }
}