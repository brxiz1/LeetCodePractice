import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T207 {
}
class Solution207 {
    List<List<Integer>> lli=new ArrayList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[] visit=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            lli.add(new ArrayList<>());
        }
        for(int[] pre :prerequisites){
            lli.get(pre[1]).add(pre[0]);
        }
//        boolean hasCircle=false;
//        for(int i=0;i<numCourses&&!hasCircle;i++){
//            if(visit[i]==0){
//                hasCircle=!dps(i,visit);
//            }
//        }
//        return !hasCircle;
        int[] input=new int[numCourses];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            for(int index:lli.get(i)){
                input[index]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            if(input[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int index=q.poll();
            List<Integer> li=lli.get(index);
            for (Integer integer : li) {
                input[integer]--;
                if (input[integer] == 0) {
                    q.offer(integer);
                }
            }
        }
        int nums=0;
        for(int in:input){
            if(in==0)nums++;
        }
        return nums==numCourses;
    }
    boolean dps(int no,int[] visit){
        visit[no]=1;
        boolean res=true;
        for(int i:lli.get(no)){
            if(visit[i]==1){
                return false;
            }else if(visit[i]==0){
                res=dps(i,visit);
                if(!res){
                    return false;
                }
            }
        }
        visit[no]=2;
        return true;
    }


}
