import java.util.Arrays;
import java.util.Stack;

public class T739 {
    public static void main(String[] args) {
        Solution739 s739=new Solution739();
        int[] res=s739.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        System.out.println(Arrays.toString(res));
    }
}
class Solution739{
    public int[] dailyTemperatures(int[] temperatures) {
        int[] date=new int[71];
        for(int i=0;i<71;i++){
            date[i]=-1;
        }
        int length=temperatures.length;
        int[] res=new int[length];
        Arrays.fill(res, length);
        //面对这类数组前端的值会取决于之后数字的问题，可以考虑从后往前遍历
        for(int i=length-1;i>=0;i--){
            int t=temperatures[i];
            for(int j=t-30+1;j<71;j++){
                if(date[j]>i){
                    res[i]=Math.min(res[i],date[j]-i);//寻求最近的一天
                }
            }
            if(res[i]==length)res[i]=0;
            date[t-30]=i;
        }
        return res;
    }
    public int[] dailyTemperatures2(int[] temperatures) {
        int length=temperatures.length;
        int[][] list=new int[length][2];
        for(int i=0;i<length;i++){
            list[i][0]=i;
            list[i][1]=temperatures[i];
        }
        Stack<int[]> s=new Stack<>();
        int[] res=new int[length];
        for(int i=0;i<length;i++){
            if(s.empty()||s.peek()[1]>=temperatures[i]){
                s.add(list[i]);
            }else{
                while(!s.empty()&&s.peek()[1]<temperatures[i]){
                    int[] l=s.pop();
                    res[l[0]]=i-l[0];
                }
                s.add(list[i]);
            }
        }

        for(int i=0;i<length;i++){
            res[i]=list[i][0];
        }
        return res;
    }
}