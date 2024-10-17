import java.util.*;

/**
 * @author ZhangYihe
 * @since 2024/10/16
 **/

public class T909 {
    public static void main(String[] args) {
        int[][] board=new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        Solution909 s909=new Solution909();
        int res= s909.snakesAndLadders(board);
        System.out.println(res);
    }
}
class Solution909{
    public int snakesAndLadders(int[][] board) {
        Queue<List<Integer>> q=new LinkedList<>();
        int length=board.length;
        int end=length*length;
        q.offer(Arrays.asList(0,1,length-1,0));//跳转次数、当前no、当前i坐标、当前j坐标
        //何时退出？检索到下一跳no==length^2
        //是否可能永远循环？————可能存在跳转循环
        //避免循环--防止重复访问某个单元格
        //要注意到，通过跳转到达某个跳转单元格和投骰子到达某个跳转单元格是不同的，前者访问了这个单元格，后者则没有
        Set<Integer> hasVisited=new HashSet<>();
        hasVisited.add(1);
        while(!q.isEmpty()){
            List<Integer> node=q.poll();
            for(int s=1;s<=6;s++){
                int nextNo=node.get(1)+s;
                if(nextNo>end)break;
//                hasVisited.add(nextNo);
                int[] nextIndex=nextStepIndex(length,nextNo);
                //遇到跳转区
                if(board[nextIndex[0]][nextIndex[1]]!=-1){
                    nextNo=board[nextIndex[0]][nextIndex[1]];
                    nextIndex=nextStepIndex(length,board[nextIndex[0]][nextIndex[1]]);
                }
                if(nextNo==end){
                    return node.get(0)+1;
                }
                if(hasVisited.contains(nextNo))continue;
                q.offer(Arrays.asList(node.get(0)+1,nextNo,nextIndex[0],nextIndex[1]));
                hasVisited.add(nextNo);
            }
        }
        return -1;
    }

    public int[] nextStepIndex(int length,int no){
        int k=(no-1)/length;
        int i=length-k-1;
        int j;
        if(k%2==0){
            j=(no-1)%length;
        }else{
            j=length-(no-1)%length-1;
        }
        return new int[]{i,j};
    }
}