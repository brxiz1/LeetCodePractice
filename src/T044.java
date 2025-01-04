import java.util.Arrays;

/**
 * @author ZhangYihe
 * @since 2025/1/4
 **/
public class T044 {
    public static void main(String[] args) {
        Solution44 s44=new Solution44();
        boolean res=s44.isMatch("aa","*");
    }
}

class Solution44{
    public boolean isMatch(String s, String p) {
        int l1=s.length();
        int l2=p.length();
        boolean[][] checkSquare=new boolean[l1+1][l2+1];
        checkSquare[0][0]=true;
        for(int i=0;i<l2;i++){
            if(p.charAt(i)!='*'){
                break;
            }else{
                checkSquare[0][i+1]=true;
            }
        }
        for(int i=0;i<l1;i++){
            char si=s.charAt(i);
            for(int j=0;j<l2;j++){
                char pj=p.charAt(j);
                if(pj=='?'){
                    checkSquare[i+1][j+1]=checkSquare[i][j];
                }else if(pj=='*'){
                    checkSquare[i+1][j+1]=checkSquare[i+1][j]||checkSquare[i][j+1];
                }else{
                    checkSquare[i+1][j+1]=checkSquare[i][j]&&si==pj;
                }
            }
        }
        return checkSquare[l1][l2];
    }
}