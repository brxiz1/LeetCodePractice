import java.util.HashMap;
import java.util.Map;

public class T219 {
}
class Solution219{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l=0;
        int r=k;
        Map<Integer,Integer> map=new HashMap<>();
        int length=nums.length;
        for(int i=l;i<=Math.min(r,length-1);i++){
            if(map.containsKey(nums[i]))return true;
            map.put(nums[i],1);
        }

        for(int i=k+1;i<length;i++){
            map.remove(nums[i-k-1]);
            if(map.containsKey(nums[i]))return true;
            else map.put(nums[i],1);
        }
        return false;
    }
}