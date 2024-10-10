import java.util.*;

/**
 * @author ZhangYihe
 * @since 2024/9/13
 **/
public class T210 {
    public static void main(String[] args) {
        int[][] prerequisites=new int[][]{{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
        Solution210 s210=new Solution210();
        int[] res=s210.findOrder(7,prerequisites);
        System.out.println(Arrays.toString(res));
    }
}
class Solution210{
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> map=new HashMap<>();//key:课程序号，value:需要在key之后学习的课程
        for(int[] nums:prerequisites){
            if(map.containsKey(nums[1])){
                List<Integer> list=map.get(nums[1]);
                list.add(nums[0]);
            }else{
                //通过List.of()生成的集合是不可变集合
                List<Integer> list=new ArrayList<>();
                list.add(nums[0]);
                map.put(nums[1],list);
            }
        }

//        List<Integer> res=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        int[] courseState=new int[numCourses];//1已分配，2分配中
        int resIndex=0;
        for(int i=0;i<numCourses;i++){
            if(courseState[i]!=0)continue;
            if(map.containsKey(i)){
                //dps
                courseState[i]=2;
//                List<Integer> list=new ArrayList<>();
//                list.add(i);
//                Stack<Integer> stack=new Stack<>();
                boolean b=dps(map,courseState,i,stack);
                if(!b){
                    return new int[0];
                }
//                while(!stack.isEmpty()){
//                    res.add(stack.pop());
//                }
                courseState[i]=1;
//                res.add(i);
//                while(!s.isEmpty()){
//                    res.add(s.pop());
//                }
            }else{
//                res.add(i);
                stack.push(i);
                courseState[i]=1;
            }
        }
        int[] result=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]=stack.pop();
        }
        return result;
    }
    //深度优先遍历会存在先遍历的分支元素被先放入栈而后遍历的分支元素后置的问题，这可能与需要的访问顺序相冲突
    //用广度优先遍历会更符合需求
    public boolean dps(Map<Integer,List<Integer>>map,int[] courseState,int index,Stack<Integer> stack){
//        if(courseState[index]==1)return true;
        //如果学习index后没有任何可学习的其它课程,则index一定没有后导课程，直接加入stack
        if(!map.containsKey(index)){
            courseState[index]=1;
            //此时stack中可能尚有未完成dps的值（因为dps可能有分支，这里可能只是分支的末尾而非完整dps的末尾）
//            while(!stack.isEmpty()){
//                list.add(stack.pop());
//            }
            stack.push(index);
            return true;
        }

        for(int i:map.get(index)){

            if(courseState[i]==2)return false;
            if(courseState[i]==0){
                courseState[i]=2;
//            stack.push(i);
//            Stack<Integer> newStack=new Stack<>();
//                stack.push(i);
                boolean res=dps(map,courseState,i,stack);

                if(!res)return false;
//                courseState[i]=1;
            }
//            while(!stack.isEmpty()){
//                list.add(stack.pop());
//            }
        }
        courseState[index]=1;
        stack.push(index);
        return true;
    }


}
//官方题解
class Solution210_2{
    // 存储有向图
    List<List<Integer>> edges;
    // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    int[] visited;
    // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶
    int[] result;
    // 判断有向图中是否有环
    boolean valid = true;
    // 栈下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }
        // 如果没有环，那么就有拓扑排序
        return result;
    }

    public void dfs(int u) {
        // 将节点标记为「搜索中」
        visited[u] = 1;
        // 搜索其相邻节点
        // 只要发现有环，立刻停止搜索//搜索有哪些课需要在学习u之后学习
        for (int v: edges.get(u)) {
            // 如果「未搜索」那么搜索相邻节点
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            }
            // 如果「搜索中」说明找到了环
            else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        // 将节点标记为「已完成」
        visited[u] = 2;
        // 将节点入栈
        result[index--] = u;
    }
}

