import java.util.HashMap;
import java.util.Map;

public class T560 {
    public static void main(String[] args) {
        Solution560 s560=new Solution560();
        int res=s560.subarraySum(new int[]{1},0);
        System.out.println(res);
    }
}
class Solution560{
    public int subarraySum(int[] nums, int k) {
        int length=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        for(int i=0;i<length;i++){
            nums[i]+=i==0?0:nums[i-1];
            res+=map.getOrDefault(nums[i]-k,0);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(nums[i]==k)res++;
        }

        return res;
    }
}
