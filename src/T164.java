import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/24
 **/
public class T164 {
    public static void main(String[] args) {
        Solution164 solution164=new Solution164();
        int[] nums=new int[]{3,6,9,1};
        int res=solution164.maximumGap(nums);
        System.out.println(res);
    }
}
class Solution164{

    public int maximumGap(int[] nums) {
        int length=nums.length;
//        List<Integer> sortedList=new ArrayList<>();
        if(length<2)return 0;
        int maxNum=Integer.MIN_VALUE;

        for(int n:nums){
            maxNum=Math.max(maxNum,n);
        }
        int[] copyNums=Arrays.copyOf(nums,nums.length);
        for(int j=1;maxNum/j>0;j*=10){

            List<List<Integer>> tempList=new ArrayList<>();
            for(int i=0;i<10;i++){
                tempList.add(new ArrayList<>());
            }

            for(int i=0;i<length;i++){
                tempList.get(copyNums[i]%10).add(nums[i]);
            }
            int index=0;

            for(List<Integer> list:tempList){
                for(int n:list){
                    nums[index]=n;
                    copyNums[index]=n/(10*j);
                    index++;
                }
            }
        }
        int maxDistance=0;
        int lastNum=nums[0];
        for(int i=1;i<length;i++){
            maxDistance=Math.max(maxDistance,nums[i]-lastNum);
            lastNum=nums[i];
        }
        return maxDistance;
    }

}