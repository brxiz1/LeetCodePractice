import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T56 {
    public static void main(String[] args) {
        Solution56 s56=new Solution56();
        System.out.println(Arrays.deepToString(s56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(interval1,interval2)->{
            return interval1[0]-interval2[0];
        });
        List<int[]> res=new ArrayList<>();
        res.add(intervals[0]);
        int i=0;
        int j=0;
        if(intervals.length==1)return intervals;
//        while(j< intervals.length){
//
//
//        }
        for(;j< intervals.length;j++){
            if(res.get(i)[1]>=intervals[j][0]){
                if(res.get(i)[1]<intervals[j][1]){
                    res.get(i)[1]=intervals[j][1];
                }
            }else{
                res.add(intervals[j]);
                i++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
