/**
 * @author ZhangYihe
 * @since 2025/1/3
 **/
public class T041 {

}

class Solution041{
    //借助nums的空间，做原地哈希以使得空间复杂度降至常数
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums.length||nums[i]<1){
                continue;
            }else if(nums[i]==i+1){
                continue;
            }else{
                change(nums,nums[i]);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i+1!=nums[i]){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public void change(int[] nums,int num){
        if(nums[num-1]==num){
            return;
        }else if(nums[num-1]>nums.length||nums[num-1]<1){
            nums[num-1]=num;
        }else{
            int temp=nums[num-1];
            nums[num-1]=num;
            change(nums,temp);
        }
    }
}
