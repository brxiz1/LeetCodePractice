/**
 * @author ZhangYihe
 * @since 2025/2/12
 **/
public class T280 {
}
class Solution280{
    public void wiggleSort(int[] nums) {
        boolean check=true;
        for(int i=1;i<nums.length;i++){
            if(check){
                if(nums[i-1]>nums[i]){
                    int temp=nums[i];
                    nums[i]=nums[i-1];
                    nums[i-1]=temp;
                }
            }else{
                if(nums[i-1]<nums[i]){
                    int temp=nums[i];
                    nums[i]=nums[i-1];
                    nums[i-1]=temp;
                }
            }
            check=!check;
        }

    }
}