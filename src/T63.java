import java.util.Arrays;

/**
 * @author ZhangYihe
 * @since 2024/12/29
 **/
public class T63 {
}
class Solution63{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int high=obstacleGrid.length;
        int width=obstacleGrid[0].length;
        int[] nums=new int[width];
        if(obstacleGrid[0][0]==1)return 0;
        nums[0]=1;
        for(int i=1;i<width;i++){
            nums[i]=obstacleGrid[0][i]==1?0:nums[i-1];
        }
        for(int i=1;i<high;i++){
            nums[0]=obstacleGrid[i][0]==1?0:nums[0];
            for(int j=1;j<width;j++){
                nums[j]=obstacleGrid[i][j]==1?0:nums[j]+nums[j-1];
            }
        }
        return nums[width-1];
    }
}