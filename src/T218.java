import java.util.*;

/**
 * @author ZhangYihe
 * @since 2025/2/1
 **/
public class T218 {

}

class Solution218{
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int[][] heights=new int[buildings.length*2][2];
        for(int i=0;i< buildings.length;i++){
            heights[2*i][0]=buildings[i][0];
            //标识左边界或者右边界
            heights[2*i][1]=-buildings[i][2];
            heights[2*i+1][0]=buildings[i][1];
            heights[2*i+1][1]=buildings[i][2];
        }
        //注意这里不止需要按坐标从小到大排序，还需要在坐标相同时按高度排序，不懂为什么
        Arrays.sort(heights, (a, b)->{
                    if (a[0] != b[0]) return a[0] - b[0];
                    return a[1] - b[1];
                });
        List<List<Integer>> resList=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int lastHeight=0;
        for(int[] height:heights){
            //如果当前边界是左边界
            //先将高度插入优先队列，然后根据队顶元素判断是否需要加入新list
            if(height[1]<0){
                pq.offer(-height[1]);

            }else{//右边界
                pq.remove(height[1]);

            }
            int h;
            if(pq.isEmpty()){
                h=0;
            }else{
                h=pq.peek();
            }
            if(h!=lastHeight){
                List<Integer> list=Arrays.asList(height[0],h);
                resList.add(list);
                lastHeight=h;
            }
        }
        return resList;
    }
}