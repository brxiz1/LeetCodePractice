import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/3
 **/
public class T037 {
}
class Solution37{
    boolean[][] row=new boolean[9][9];//第i行是否已经填入了数字j
    boolean[][] column=new boolean[9][9];//第i列是否已经填入了数字j
    boolean[][][] square=new boolean[3][3][9];//3*3方格i,j是否已经填入了数字k
    public void solveSudoku(char[][] board) {

        //确定递归队列
        List<List<Integer>> lli=new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    lli.add(List.of(i,j));
                }else{
                    int num=board[i][j]-'1';
                    row[i][num]=true;
                    column[j][num]=true;
                    square[i/3][j/3][num]=true;
                }
            }
        }
        searchAndSet(lli,0,board);
    }

    public boolean searchAndSet(List<List<Integer>> lli,int index,char[][] board){
        int i=lli.get(index).get(0);
        int j=lli.get(index).get(1);
        for(int num=0;num<9;num++){
            if(checkAndSet(i,j,num,board)){
                if(index==lli.size()-1){
                    return true;
                }
                if(searchAndSet(lli,index+1,board)){
                    return true;
                }else{
                    row[i][num]=false;
                    column[j][num]=false;
                    square[i/3][j/3][num]=false;
                    board[i][j]='.';
                }
            }
        }
        return false;
    }
    public boolean checkAndSet(int i,int j,int num,char[][] board){
        if(!row[i][num]&&!column[j][num]&&!square[i/3][j/3][num]){
            row[i][num]=true;
            column[j][num]=true;
            square[i/3][j/3][num]=true;
            board[i][j]= (char) (num+'1');

            return true;
        }else{
            return false;
        }
    }
}