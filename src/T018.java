import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2024/12/29
 **/
public class T018 {
    public static void main(String[] args) {
        Solution018 s18=new Solution018();
        List<List<Integer>> reslist=s18.fourSum(new int[]{1,0,-1,0,-2,2},0);
        System.out.println(reslist);
    }
}

class Solution018{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length=nums.length;
        List<List<Integer>> resList=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<length-3;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            for(int j=i+1;j<length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1])continue;
                int left=j+1;
                int right=length-1;
                while(left<right){
                    long sum=(long)nums[i]+(long)nums[j]+(long)nums[left]+(long)nums[right];
                    if(sum==target){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        resList.add(list);
                        left++;
                        while(left<length-1&&left>j+1&&nums[left]==nums[left-1])left++;
                        right--;
                        while(right>j+1&&right<length-1&&nums[right]==nums[right+1])right--;
                    }else if(sum<target){
                        left++;
                        while(left<length-1&&left>j+1&&nums[left]==nums[left-1])left++;
                    }else{
                        right--;
                        while(right>j+1&&right<length-1&&nums[right]==nums[right+1])right--;
                    }
                }
            }
        }
        return resList;
    }
}