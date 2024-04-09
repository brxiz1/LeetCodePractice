public class T152 {
}

class Solution152{
    public int maxProduct(int[] nums) {
        int minbefore=1;
        int maxbefore=1;
        int res=nums[0];
        for(int num :nums){
            int temp_minbefore=Math.min(num,Math.min(num*minbefore,num*maxbefore));
            int temp_maxbefore=Math.max(num,Math.max(num*minbefore,num*maxbefore));
            minbefore=temp_minbefore;
            maxbefore=temp_maxbefore;
            res=Math.max(res,Math.max(minbefore,maxbefore));
        }
        return res;
    }
}