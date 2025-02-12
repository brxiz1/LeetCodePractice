import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author ZhangYihe
 * @since 2025/2/5
 **/
public class T264 {

}

class Solution264{
    //基于优先队列的方法
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        q.offer(1);
        Set<Integer> set=new HashSet<>();
        for(int i=1;i<n;i++){
            int min=q.poll();
            int m2=Math.min(Integer.MAX_VALUE/2,min)*2;
            int m3=Math.min(Integer.MAX_VALUE/3,min)*3;
            int m5=Math.min(Integer.MAX_VALUE/5,min)*5;
            if(!set.contains(m2)){
                q.offer(m2);
                set.add(m2);
            }
            if(!set.contains(m3)){
                q.offer(m3);
                set.add(m3);
            }
            if(!set.contains(m5)){
                q.offer(m5);
                set.add(m5);
            }
        }
        return q.poll();
    }
    //基于动态规划的解法
    public int nthUglyNumber2(int n) {
        int[] uglyNums=new int[n];
        int index2=0;
        int index3=0;
        int index5=0;
        uglyNums[0]=1;
        for(int i=1;i<n;i++){
            int m2=uglyNums[index2]*2;
            int m3=uglyNums[index3]*3;
            int m5=uglyNums[index5]*5;
            uglyNums[i]=Math.min(Math.min(m2,m3),m5);
            if(uglyNums[i]==m2)index2++;
            if(uglyNums[i]==m3)index3++;
            if(uglyNums[i]==m5)index5++;
        }
        return uglyNums[n-1];
    }
}