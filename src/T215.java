import java.util.Random;

public class T215 {

}
//快速选择算法*****
class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int length=nums.length;
        int left=0;
        int right=length-1;
        while(true){
            int aim=findk(nums,left,right);
            if(aim==length-k)return nums[aim];
            else if(aim>length-k){
                right=aim-1;
            }else{
                left=aim+1;
            }
        }
    }
    public int findk(int[] nums,int left,int right){
        Random ran=new Random();
        int re=ran.nextInt(left,right+1);
        int temp=nums[left];
        nums[left]=nums[re];
        nums[re]=temp;
        int l=left+1;
        int r=right;
        while(true){
            //while(nums[left]>=nums[l]&&r>=l)
            // 注意这个写法是错的，nums[l]在l++后可能越界
            while(l<=r&&nums[left]>=nums[l]){
                l++;
            }
            while(r>=l&&nums[left]<=nums[r]){
                r--;
            }
            if(r<=l){
                break;
            }
            temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            //少了这里的l++和r--会有极端案例超时，不知道为什么
            l++;
            r--;
        }
        //循环结束后，r指向最后一个小于指标的数字或一个等于指标的数字，
        // l指向第一个大于指标的数字或一个等于指标的数字
        temp=nums[left];
        nums[left]=nums[r];
        nums[r]=temp;
        return r;
    }
}