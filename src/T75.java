import java.util.Arrays;

public class T75 {
    public static void main(String[] args) {
        Solution75 s75=new Solution75();
        int[] nums=new int[]{2,0,1};
        s75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
class Solution75 {
    public void sortColors(int[] nums) {
        int index0=0;
        int index2=nums.length-1;
        for(int i=0;i<=index2;i++){
            while(nums[i]!=1&&i>=index0&&i<=index2){
                int temp=-2;
                if(nums[i]==0){
                    nums[i]=nums[index0];
                    nums[index0]=0;
                    index0++;
                }else if(nums[i]==2){
                    nums[i]=nums[index2];
                    nums[index2]=2;
                    index2--;
                }
            }
        }
    }
}