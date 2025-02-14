/**
 * @author ZhangYihe
 * @since 2025/2/14
 **/
public class T304 {
}

class NumMatrix{
    int[][] square;
    int row;
    int column;
    public NumMatrix(int[][] matrix) {
        row= matrix.length;
        column=matrix[0].length;
        square=new int[row][column];
        square[0][0]=matrix[0][0];
        for(int i=1;i<row;i++){
            square[i][0]=square[i-1][0]+matrix[i][0];
        }
        for(int j=1;j<column;j++){
            square[0][j]=square[0][j-1]+matrix[0][j];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<column;j++){
                square[i][j]=square[i-1][j]+square[i][j-1]-square[i-1][j-1]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1==0&&col1==0){
            return square[row2][col2];
        }else if(row1==0){
            return square[row2][col2]-square[row2][col1-1];
        }else if(col1==0){
            return square[row2][col2]-square[row1-1][col2];
        }else{
            return square[row2][col2]+square[row1-1][col1-1]-square[row1-1][col2]-square[row2][col1-1];
        }
    }
}