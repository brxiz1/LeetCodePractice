public class T62 {
}
class Solution62 {
    //用动态规划解能否到达问题：能否到达某个方块取决于能否到达相邻方块。
    public int uniquePaths(int m, int n) {
        int[][] nums=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    nums[i][j]=1;
                }else{
                    nums[i][j]=nums[i-1][j]+nums[i][j-1];
                }
            }

        }
        return nums[m-1][n-1];
    }
}