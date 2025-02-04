import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ZhangYihe
 * @since 2025/2/3
 **/
public class T252 {
}

class Solution252{
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int lastEnd=0;
        for(int[] interval:intervals){
            if(lastEnd>interval[0])return false;
            lastEnd=interval[1];
        }
        return true;
    }
}