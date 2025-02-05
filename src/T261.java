import java.util.Arrays;

/**
 * @author ZhangYihe
 * @since 2025/2/4
 **/
public class T261 {
    public static void main(String[] args) {
        Solution261 solution261=new Solution261();
        int[][] edges=new int[][]{
                {0, 1}, {0, 2}, {2, 3}, {2, 4}
        };
        boolean res=solution261.validTree(5,edges);
        System.out.println(res);
    }
}

class Solution261{
    public boolean validTree(int n, int[][] edges) {
        DisjointSet djSet=new DisjointSet(n);
        if(edges.length!=n-1){
            return false;
        }
        for(int[] edge:edges){
            if(!djSet.join(edge[0],edge[1])){
                return false;
            }
        }
        int parent=djSet.find(0);
        for(int i=1;i<n;i++){
            if(djSet.find(i)!=parent)return false;
        }
        return true;
    }
}

class DisjointSet{
    int[] parents;
    int[] height;
    DisjointSet(int n){
        parents=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        height=new int[n];
        Arrays.fill(height,0);
    }
    boolean join(int i,int j){
        if(find(i)==find(j)){
            return false;
        }
        if(height[find(i)]>height[find(j)]){
            parents[find(j)]=find(i);
        }else if(height[find(i)]<height[find(j)]){
            parents[find(i)]=find(j);
        }else{
            parents[find(i)]=find(j);
            height[find(i)]++;
        }
        return true;
    }

    int find(int i){
        if(parents[i]==i){
            return parents[i];
        }else{
            parents[i]=find(parents[i]);
            return parents[i];
        }
    }
}