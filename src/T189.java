import java.util.Arrays;

public class T189 {
    public static void main(String[] args) {
        Solution189 solution189=new Solution189();
        int[] nums=new int[]{1,2,3,4,5,6,7};
        solution189.rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
}
class Solution189{
    //对数组做轮转就相当于做三次翻转
    public void rotate(int[] nums, int k) {
        int length=nums.length;
        k=k%length;
        reverse(nums,0,length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);
    }
    public void reverse(int[] nums,int left,int right){
        int length=right-left+1;
        for(int i=left;i<left+length/2;i++){
            int temp=nums[i];
            nums[i]=nums[left+right-i];
            nums[left+right-i]=temp;
        }
    }
}
