import java.util.Stack;

public class T85 {
}
class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int[][] heights=new int[matrix.length][matrix[0].length];
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0){
                    heights[i][j]=matrix[i][j]=='1'?1:0;
                }
                else{
                    heights[i][j]=matrix[i][j]=='1'?heights[i][j-1]+1:0;
                }
            }
        }
        Stack<Integer> s=new Stack<>();
        int[] left=new int[matrix.length];
        int[] right=new int[matrix.length];
        int max=0;
        for(int j=0;j<matrix[0].length;j++){
            for(int i=0;i<matrix.length;i++){
                while(!s.empty()&&heights[s.peek()][j]>heights[i][j]){
                    right[s.pop()]=i;
                }
                if(s.empty()){
                    s.push(i);
                    left[i]=-1;
                }else{
                    left[i]=s.peek();
                    s.push(i);
                }
            }
            while(!s.empty()){
                right[s.pop()]=heights.length;
            }
            for(int i=0;i<matrix.length;i++){
                max=Math.max(max,(right[i]-left[i]-1)*heights[i][j]);
            }
        }
        return max;
    }
}