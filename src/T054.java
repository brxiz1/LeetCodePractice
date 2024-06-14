import java.util.ArrayList;
import java.util.List;

public class T054 {
}
class Solution54{
    public List<Integer> spiralOrder(int[][] matrix) {
        int row= matrix.length;
        int column=matrix[0].length;
        int startIndex=0;
        List<Integer> list=new ArrayList<>();
        for(;row>0&&column>0;row-=2,column-=2,startIndex++){
            for(int j=0;j<column;j++){
                list.add(matrix[startIndex][startIndex+j]);
            }
            for(int i=1;i<row;i++){
                list.add(matrix[startIndex+i][startIndex+column-1]);
            }
            for(int j=column-2;j>=0&&row>1;j--){
                list.add(matrix[startIndex+row-1][startIndex+j]);
            }
            for(int i=row-2;i>=1&&column>1;i--){
                list.add(matrix[startIndex+i][startIndex]);
            }
        }
        return list;
    }
}
