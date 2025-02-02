import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/2/2
 **/
public class T229 {
}

class Solution229{
    //投票削去法解决多数元素问题
    public List<Integer> majorityElement(int[] nums) {
        int[][] votes=new int[2][2];
        votes[0][0]=Integer.MIN_VALUE;
        votes[1][0]=Integer.MIN_VALUE;
        for(int n:nums){
            if(votes[0][0]==n){
                votes[0][1]++;
            }else if(votes[1][0]==n){
                votes[1][1]++;
            }else{
                if(votes[0][1]==0){
                    votes[0][0]=n;
                    votes[0][1]=1;
                }else if(votes[1][1]==0){
                    votes[1][0]=n;
                    votes[1][1]=1;
                }else{
                    votes[0][1]--;
                    votes[1][1]--;
                }
            }
        }
        int[] count=new int[2];
        for(int n:nums){
            if(votes[0][0]==n){
                count[0]++;
            }else if(votes[1][0]==n){
                count[1]++;
            }
        }
        List<Integer> res=new ArrayList<>();
        if(count[0]> nums.length/3)res.add(votes[0][0]);
        if(count[1]> nums.length/3)res.add(votes[1][0]);
        return res;
    }
}