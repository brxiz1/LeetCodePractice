public class T289 {
    public static void main(String[] args) {
        Solution289 solution289=new Solution289();
        int[][] board=new int[][]{{1,1},{0,0}};
        solution289.gameOfLife(board);
        System.out.println(board.toString());
    }
}
class Solution289{
    public void gameOfLife(int[][] board) {
        int row= board.length;
        int column=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                int count=0;
                for(int m=-1;m<2;m++){
                    for(int n=-1;n<2;n++){
                        if(m==0&&n==0)continue;
                        if(i+m>=0&&i+m<row&&j+n>=0&&j+n<column){
                            count+=(board[i+m][j+n]>0?1:0);
                        }
                    }
                }
                if((count>3||count<2)&&board[i][j]==1){
                    board[i][j]=2;
                }else if(count==3&&board[i][j]==0){
                    board[i][j]=-1;
                }

            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }else if(board[i][j]==-1){
                    board[i][j]=1;
                }
            }
        }
    }

}