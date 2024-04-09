public class T221 {
}
class Solution221{
    public int maximalSquare(char[][] matrix) {
        int row=matrix.length;
        int len=matrix[0].length;
        int[][] maxLength=new int[row][len];
        for(int i=0;i<row;i++){
            if(matrix[i][0]=='1'){
                maxLength[i][0]=1;
            }else{
                maxLength[i][0]=0;
            }
        }
        for(int j=0;j<len;j++){
            if(matrix[0][j]=='1'){
                maxLength[0][j]=1;
            }
            else{
                maxLength[0][j]=0;
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<len;j++){
                if(matrix[i][j]=='1'){
                    maxLength[i][j]=Math.min(maxLength[i-1][j],
                            Math.min(maxLength[i-1][j-1],maxLength[i][j-1]))+1;
                }
            }
        }
        int max=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<len;j++){
                max=Math.max(max,maxLength[i][j]);
            }
        }
        return max*max;
    }
}