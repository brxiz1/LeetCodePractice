public class T79 {
    public static void main(String[] args) {
        Solution79 s79=new Solution79();
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(s79.exist(board,"SEEA"));
    }

}

class Solution79 {
    public boolean exist(char[][] board, String word) {
        char[] w=word.toCharArray();
        boolean[][] isUsed=new boolean[board.length][board[0].length];
        for(boolean[] bis:isUsed){
            for(boolean bi:bis){
                bi=false;
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(isExist(board,w,0,isUsed,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isExist(char[][] board,char[] word,int index,
                           boolean[][] isUsed,int i,int j){
        if(board[i][j]!=word[index]||isUsed[i][j]){
//            board[i][j]='#';
            return false;
        }
        if(index==word.length-1)return true;

        isUsed[i][j]=true;
        if(i>0){
            if(isExist(board,word,index+1,isUsed,i-1,j)){
                return true;
            }
        }
        if(i<board.length-1){
            if(isExist(board,word,index+1,isUsed,i+1,j)){
                return true;
            }
        }
        if(j>0){
            if(isExist(board,word,index+1,isUsed,i,j-1)){
                return true;
            }
        }
        if(j<board[0].length-1){
            if(isExist(board,word,index+1,isUsed,i,j+1)){
                return true;
            }
        }
        isUsed[i][j]=false;
        return false;
    }
}