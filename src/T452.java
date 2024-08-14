import java.util.Arrays;
import java.util.PriorityQueue;

public class T452 {
    public static void main(String[] args) {
        Solution452 s452=new Solution452();
        int res=s452.findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}});
        System.out.println(res);
    }
}
class Solution452{
    public int findMinArrowShots(int[][] points) {
        //这里l1[1]-l2[1]有可能超出int的范围
        PriorityQueue<int[]> queue=new PriorityQueue<>((l1,l2)-> {
            if(l1[1]>l2[1])return 1;
            if(l1[1]<l2[1])return -1;
            return 0;
        });
        queue.addAll(Arrays.asList(points));
        int arrowNum=0;
        for(int i=0;i<points.length;i++){
            int[] end=queue.poll();
            for(int j=i+1;j<points.length;j++){
                if (queue.peek() != null && queue.peek()[0] <= end[1]) {
                    queue.poll();
                    i++;
                }
            }
            arrowNum++;
        }
        return arrowNum;
    }
}