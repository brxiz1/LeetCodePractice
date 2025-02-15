import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ZhangYihe
 * @since 2025/2/15
 **/
public class T305 {
}

class Solution305{
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        Set<Integer> visited=new HashSet<>();
//        int length= positions.length;
        FindJoinSet set=new FindJoinSet(m*n);
        List<Integer> ans=new ArrayList<>();
        for(int[] position:positions){
            int i=position[0],j=position[1];
            int index=position[0]*n+position[1];
            if(visited.contains(index)){
                ans.add(set.count);
                continue;
            }
            visited.add(index);
            set.addLand();
            if(i-1>=0&&visited.contains((i-1)*n+j)){
                set.join(index,(i-1)*n+j);
            }
            if(i+1<m&& visited.contains((i+1)*n+j)){
                set.join(index,(i+1)*n+j);
            }
            if(j-1>=0&&visited.contains(i*n+j-1)){
                set.join(index,i*n+j-1);
            }
            if(j+1<n&&visited.contains(i*n+j+1)){
                set.join(index,i*n+j+1);
            }
            ans.add(set.count);
        }
        return ans;
    }

}

class FindJoinSet{
    int[] parent;
    int[] height;
    int count;
    public FindJoinSet(int n){
        parent=new int[n];
        height=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            height[i]=1;
        }
    }

    public int find(int i){
        if(parent[i]!=i){
            int p=find(parent[i]);
            parent[i]=p;
            return p;
        }
        return i;
    }
    public void addLand(){
        count++;
    }
    public void join(int i,int j){
        if(find(i)==find(j))return;
        int pi=find(i),pj=find(j);
        if(height[pi]>height[pj]){
            parent[pj]=pi;
        }else if(height[pi]==height[pj]){
            parent[pj]=pi;
            height[pi]++;
        }else{
            parent[pi]=pj;
        }
        count--;
    }

}