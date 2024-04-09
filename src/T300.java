import java.util.Arrays;

public class T300 {
    public static void main(String[] args) {
        Solution300 s300=new Solution300();
        System.out.println(s300.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}
//贪心算法的应用
class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] tailNum=new int[nums.length+1];
        tailNum[0]=Integer.MIN_VALUE;
        tailNum[1]=nums[0];
        int maxLen=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>tailNum[maxLen]){
                tailNum[++maxLen]=nums[i];
            }else{
                int j=maxLen;
                while(tailNum[j]>=nums[i]&&j>0){
                    j--;
                }
                tailNum[j+1]=nums[i];
            }
        }
        System.out.println(Arrays.toString(tailNum));
        return maxLen;
    }
}