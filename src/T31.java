import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T31 {
    public static void main(String[] args) {
        Solution31 s31=new Solution31();
        int[] nums=new int[]{2,3,1};
        s31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
class Solution31 {
    public void nextPermutation(int[] nums) {
        int length=nums.length;
        int i=length-1;
        int j=0;

        for(;i>0;i--){
            if(nums[i]>nums[i-1]){
                j=length-1;
                break;
            }
        }

        if(i==0){
            for(int k=0;k<length/2;k++){
                int change=nums[k];
                nums[k]=nums[length-1-k];
                nums[length-1-k]=change;
            }
            return;
        }
        i=i-1;
        for(;j>i;j--){
            if(nums[j]>nums[i])break;
        }
        int change=nums[i];
        nums[i]=nums[j];
        nums[j]=change;
        Arrays.sort(nums,i+1,length);
    }
}
