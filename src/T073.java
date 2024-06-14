public class T073 {
}
class Solution73{
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int column=matrix[0].length;
        int[] rowList=new int[row];
        int[] columnList=new int[column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(matrix[i][j]==0){
                    rowList[i]=1;
                    columnList[j]=1;
                }
            }
        }
        for(int i=0;i<row;i++){
            if(rowList[i]==1){
                for(int j=0;j<column;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=0;j<column;j++){
            if(columnList[j]==1){
                for(int i=0;i<row;i++){
                    matrix[i][j]=0;
                }
            }
        }

    }
}
