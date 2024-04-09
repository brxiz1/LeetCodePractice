import java.util.Stack;

public class T84 {
    public static void main(String[] args) {
        Solution84 s84=new Solution84();
        System.out.println(s84.largestRectangleArea(new int[]{2,4}));
    }
}
class Solution84 {
    //以当前高度为基准向左右延伸，判断满足当前高度的最大宽度
    //利用单调栈特性解决大小比较后的信息保存，将满足大小顺序的数压入，遇到不满足的数时按需求弹出
    public int largestRectangleArea(int[] heights) {
        int[] left=new int[heights.length];
        int[] right=new int[heights.length];
        Stack<Integer> s=new Stack<>();
        int max=0;
        for(int i=0;i<heights.length;i++){
            while(!s.empty()&&heights[s.peek()]>heights[i]){
                int j=s.pop();
                right[j]=i;
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
        for(int i=0;i<heights.length;i++){
            max=Math.max(max,(right[i]-left[i]-1)*heights[i]);
        }
        return max;
    }
}