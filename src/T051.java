import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/4
 **/
public class T051 {
    public static void main(String[] args) {
        Solution51 s51=new Solution51();
        List<List<String>> lls=s51.solveNQueens(4);
        System.out.println(lls);
    }
}

class Solution51{
    boolean[] column;
    boolean[] lineX;//'/'和相同
    boolean[] lineY;//'\'差相同
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lls=new ArrayList<>();
        column=new boolean[n];
        lineX=new boolean[2*n-1];
        lineY=new boolean[2*n-1];
        backTracking(n,0,new ArrayList<>(),lls);
        return lls;
    }

    public void backTracking(int total,int n,List<String> list,List<List<String>> lls){
        if(n>=total){
            lls.add(new ArrayList<>(list));
        }

        for(int i=0;i<total;i++){
            if(column[i]||lineX[n+i]||lineY[n-i+total-1]){
                continue;
            }
            column[i]=true;
            lineX[n+i]=true;
            lineY[n-i+total-1]=true;
            StringBuilder sb=new StringBuilder();
            sb.append(".".repeat(Math.max(0, total)));
            sb.setCharAt(i,'Q');
            list.add(sb.toString());

            backTracking(total,n+1,list,lls);

            column[i]=false;
            lineX[n+i]=false;
            lineY[n-i+total-1]=false;
            list.remove(list.size()-1);
        }
    }
}