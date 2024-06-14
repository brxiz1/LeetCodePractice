public class T036 {
}
class Solution {
    public boolean isValidSudoku(char[][] board) {
//        int rowLength=board.length;
//        int columnLength=board[0].length;
        int[][] rowCount=new int[9][10];
        int[][] columnCount =new int[9][10];
        int[][][] blockCount=new int[3][3][10];
        for(int i=0;i<9;i++){

            for(int j=0;j<9;j++){
                if(board[i][j]=='.')continue;
                int num=board[i][j]-'0';
                rowCount[i][num]++;
                columnCount[j][num]++;
                blockCount[i/3][j/3][num]++;
                if(rowCount[i][num]>1|| columnCount[j][num]>1||blockCount[i/3][j/3][num]>1){
                    return false;
                }
            }
        }
//        for(int i=0;i<9;i++){
//            for(int j=0;j<10;j++){
//                if(rowCount[i][j]>1||columnCount[i][j]>1){
//                    return false;
//                }
//            }
//        }
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                for(int k=0;k<10;k++){
//                    if(blockCount[i][j][k]>1){
//                        return false;
//                    }
//                }
//            }
//        }
        return true;
    }
}