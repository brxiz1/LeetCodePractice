import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/2/14
 **/
public class T296 {
}

class Solution296{
    public int minTotalDistance(int[][] grid) {
        int homeNums=0;
        List<Integer> homeIndexList=new ArrayList<>();

        int rows= grid.length;
        int column=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]==1){
                    homeIndexList.add(i);
                    homeNums++;
                }
            }
        }
        int midIndex=homeNums/2;//有偶数个时会优先中间右侧
        int index1=homeIndexList.get(midIndex);
        int totalRowDistance=0;
        for(int i:homeIndexList){
            totalRowDistance+=Math.abs(index1-i);
        }

        homeIndexList=new ArrayList<>();
        for(int j=0;j<column;j++){
            for(int i=0;i<rows;i++){
                if(grid[i][j]==1){
                    homeIndexList.add(j);
                    homeNums++;
                }

            }
        }
        int index2=homeIndexList.get(midIndex);
        int totalColumnDistance=0;
        for(int j:homeIndexList){
            totalColumnDistance+=Math.abs(index2-j);
        }
        return totalColumnDistance+totalRowDistance;
    }
}