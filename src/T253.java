import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ZhangYihe
 * @since 2025/2/3
 **/
public class T253 {
    public static void main(String[] args) {
        int[][] intervals=new int[][]{
                {5, 8}, {6, 8}
        };
        Solution253 s253=new Solution253();
        int res=s253.minMeetingRooms(intervals);
        System.out.println(res);
    }
}

class Solution253{
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int maxRoom=0;
        int nowRoom=0;
        for(int i=0;i<intervals.length;i++){
            if(queue.isEmpty()){
                queue.offer(intervals[i][1]);
                nowRoom++;
                maxRoom=Math.max(maxRoom,nowRoom);
                continue;
            }

            while(!queue.isEmpty()&&queue.peek()<=intervals[i][0]){
                int lt=queue.poll();
                nowRoom--;
            }
            queue.offer(intervals[i][1]);
            nowRoom++;
            maxRoom=Math.max(maxRoom,nowRoom);
        }
        return maxRoom;
    }
}