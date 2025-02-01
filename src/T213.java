/**
 * @author ZhangYihe
 * @since 2025/2/1
 **/
public class T213 {
}
class Solution213{
    //在环形路径上的动态规划问题：考虑将依照条件将环形链路打断，分成0至n-1和1至n两段链路，以避免0和n位间的互相干扰
    public int rob(int[] nums) {
        int length=nums.length;
        if(length==1)return nums[0];
        else if(length==2)return Math.max(nums[0],nums[1]);
        int[][] maxValue=new int[length][2];
        //最后一间屋子不抢
        maxValue[0][1]=nums[0];
        for(int i=1;i<length-1;i++){
            maxValue[i][0]=Math.max(maxValue[i-1][0],maxValue[i-1][1]);
            maxValue[i][1]=maxValue[i-1][0]+nums[i];
        }
        int res=Math.max(maxValue[length-2][0],maxValue[length-2][1]);
        //第一间屋子不抢
        maxValue[1][1]=nums[1];
        maxValue[1][0]=0;
        for(int i=2;i<length;i++){
            maxValue[i][0]=Math.max(maxValue[i-1][0],maxValue[i-1][1]);
            maxValue[i][1]=maxValue[i-1][0]+nums[i];
        }
        res=Math.max(res,Math.max(maxValue[length-1][0],maxValue[length-1][1]));
        return res;
    }
}
