/**
 * @author ZhangYihe
 * @since 2025/2/5
 **/

public class T268 {
}

class Solution268{
    public int missingNumber(int[] nums) {
        int res=0;
        for(int i=0;i<=nums.length;i++){
            res+=i;
        }
        for(int n:nums){
            res-=n;
        }
        return res;
    }
}