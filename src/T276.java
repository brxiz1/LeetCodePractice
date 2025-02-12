/**
 * @author ZhangYihe
 * @since 2025/2/12
 **/
public class T276 {
}

class Solution276{
    public int numWays(int n, int k) {
        int[][] totalNums=new int[n][2];//0:与涂上与前一位相同的颜色的可能，1：涂上不同颜色的可能
        totalNums[0][0]=0;
        totalNums[0][1]=k;
        for(int i=1;i<n;i++){
            totalNums[i][0]=totalNums[i-1][1];
            totalNums[i][1]=(k-1)*(totalNums[i-1][0]+totalNums[i-1][1]);
        }
        return totalNums[n-1][0]+totalNums[n-1][1];
    }
}