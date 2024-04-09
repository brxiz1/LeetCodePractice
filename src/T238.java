public class T238 {

}
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int length=nums.length;
        int[] leftmultify=new int[length];
        leftmultify[0]=1;
        for(int i=1;i<length;i++){
            leftmultify[i]=leftmultify[i-1]*nums[i-1];
        }
        int rightmultify=1;
        for(int i=length-1;i>=0;i--){
            leftmultify[i]=rightmultify*leftmultify[i];
            rightmultify*=nums[i];
        }
        return leftmultify;
    }
}