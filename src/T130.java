import java.util.*;

/**
 * @author ZhangYihe
 * @since 2024/9/13
 **/
public class T130 {
    public static void main(String[] args) {
        Solution130 s130=new Solution130();
        char[][]board=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        s130.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

}
class Solution130{
    public void solve(char[][] board) {
        int m= board.length;
        int n=board[0].length;
        Queue<List<Integer>> queue=new LinkedList<>();
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                queue.offer(List.of(0,j));
                board[0][j]='1';
            }
            if(board[m-1][j]=='O'){
                queue.offer(List.of(m-1,j));
                board[m-1][j]='1';
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                queue.offer(List.of(i,0));
                board[i][0]='1';

            }
            if(board[i][n-1]=='O'){
                queue.offer(List.of(i,n-1));
                board[i][n-1]='1';
            }
        }
        while(!queue.isEmpty()){
            List<Integer> list=queue.poll();
            int i=list.get(0),j=list.get(1);
            if(i>0&&board[i-1][j]=='O'){
                queue.offer(List.of(i-1,j));
                board[i-1][j]='1';
            }
            if(i<m-1&&board[i+1][j]=='O'){
                queue.offer(List.of(i+1,j));
                board[i+1][j]='1';
            }
            if(j>0&&board[i][j-1]=='O'){
                queue.offer(List.of(i,j-1));
                board[i][j-1]='1';
            }
            if(j<n-1&&board[i][j+1]=='O'){
                queue.offer(List.of(i,j+1));
                board[i][j+1]='1';
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='1'){
                    board[i][j]='O';
                }
            }
        }
    }
}