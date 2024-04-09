import java.util.*;

public class T128 {
    public static void main(String[] args) {
        Solution128 s128=new Solution128();
        System.out.println(s128.longestConsecutive(new int[]{

        }));
    }
}

class Solution128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        if(nums.length==0)return 0;
//        for(int i:nums){
//            map.put(i,1);
//        }
        int max=1;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-1)){
                map.put(nums[i],map.get(nums[i]-1)+1);
                max=Math.max(map.get(nums[i]),max);
            }else{
                map.put(nums[i],1);
            }
            int j=1;
            for(;map.containsKey(j+nums[i]);j++){
                if(map.get(j+nums[i])==map.get(nums[i])+j)break;
                map.put(j+nums[i],map.get(nums[i])+j);

            }
            max=Math.max(map.get(nums[i]+j-1),max);
        }

//        for(int i:nums){
//            if(map.containsKey(i-1))continue;
//            int m=1;
//            for(int j=1;map.containsKey(i+j);j++){
//                m++;
//            }
//            max=Math.max(m,max);
//        }
        return max;
    }
}
