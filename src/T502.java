import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ZhangYihe
 * @since 2024/12/26
 **/
public class T502 {
    public static void main(String[] args) {
        Solution502 s502=new Solution502();
        int[] profits=new int[]{1,2,3};
        int[] capital=new int[]{0,0,0};
        int res=s502.findMaximizedCapital(1,100,profits,capital);
        System.out.println(res);
    }

}

class Solution502{

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<Integer> queue=new PriorityQueue<>((i1,i2)-> i2-i1);
        int length=capital.length;
        int[][] pc=new int[length][2];
        for(int i=0;i<length;i++){
            pc[i][0]=capital[i];
            pc[i][1]=profits[i];
        }
        Arrays.sort(pc, Comparator.comparingInt(i -> i[0]));
        if(w>pc[length-1][0]){
            int res=w;
            for(int i=0;i<k;i++){
                res+=pc[length-1-i][1];
            }
            return res;
        }

        int check=-1;
        for(int i=0;i<length;i++){
            int c=pc[i][0];
            if(c>w){
                break;
            }
            check++;
            queue.offer(pc[i][1]);
        }
        if(check==-1){
            return w;
        }

        int res=w;
        for(int i=0;i<k&&!queue.isEmpty();i++){
            res+=queue.poll();
            for(int j=check+1;j<length;j++){
                if(pc[j][0]>res){
                    break;
                }else{
                    check++;
                    queue.offer(pc[j][1]);
                }
            }
        }
        return res;
    }


}