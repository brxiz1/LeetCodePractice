import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15 {
    public static void main(String[] args) {
        Solution15 s15=new Solution15();
        System.out.println(s15.threeSum(new int[]{}));
    }
}
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lli=new ArrayList<>();
        int length=nums.length;
        int right=length-1;

        for(int i=0;i<right;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
//            right=length-1;
            for(int left=i+1;left<right;left++){

                System.out.println(left);
                if(left>i+1&&nums[left]==nums[left-1]) continue;
                while(nums[i]+nums[left]+nums[right]>0){
                        right--;
                        if(right<=left){
                            break;
                        }
                }

                if(right!=left&&nums[i]+nums[left]+nums[right]==0&&(right+1==length||nums[right]!=nums[right+1])){
                    lli.add(new ArrayList<>(List.of(new Integer[]{nums[i], nums[left], nums[right]})));
                }
//                if(nums[i]+nums[left]+nums[right]<0){
//                    continue;
//                }

            }
//            System.out.println(i);
        }
        return lli;
    }
}