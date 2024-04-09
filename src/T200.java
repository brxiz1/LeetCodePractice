public class T200 {
}
class Solution200 {
    char[][] grid;
    int row;
    int column;
    public int numIslands(char[][] grid) {
        row=grid.length;
        column=grid[0].length;
        this.grid=grid;
//        int nums=0;
//        for(int i=0;i<row;i++){
//            for(int j=0;j<column;j++){
//                if(grid[i][j]=='1'){
//                    dfs(i,j);
//                    nums++;
//                }
//            }
//        }
//        return nums;
        Union u=new Union(row,column);
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]=='1'){
                    grid[i][j]='0';
                    if(i>0&&grid[i-1][j]=='1'){
                        u.join(i,j,i-1,j);
//                        grid[i][j]='0';
                    }
                    if(i<row-1&&grid[i+1][j]=='1'){
                        u.join(i,j,i+1,j);
                    }
                    if(j>0&&grid[i][j-1]=='1'){
                        u.join(i,j,i,j-1);
                    }
                    if(j<column-1&&grid[i][j+1]=='1'){
                        u.join(i,j,i,j+1);
                    }
                }
            }
        }
        return u.treeNums;
    }
    void dfs(int i,int j){
        grid[i][j]='0';
        if(i>0&&grid[i-1][j]=='1'){
            dfs(i-1,j);
        }
        if(i<row-1&&grid[i+1][j]=='1'){
            dfs(i+1,j);
        }
        if(j>0&&grid[i][j-1]=='1'){
            dfs(i,j-1);
        }
        if(j<column-1&&grid[i][j+1]=='1'){
            dfs(i,j+1);
        }
    }
    class Union{
        int[] parent;
        int[] rank;
        int treeNums;
        Union(int row,int column){
            parent=new int[row*column];
            rank=new int[row*column];
            treeNums=0;
            for(int i=0;i<row;i++){
                for(int j=0;j<column;j++){
                    if(grid[i][j]=='1'){
                        parent[i*column+j]=i*column+j;
                        rank[i*column+j]=0;
                        treeNums++;
                    }
                }
            }
        }
        int find(int i,int j){
            if(parent[i*column+j]!=i*column+j){

                return find(parent[i*column+j]/column,parent[i*column+j]%column);
            }else{
                return i*column+j;
            }
        }

        void join(int i1,int j1,int i2,int j2){
            int f1=find(i1,j1);
            int f2=find(i2,j2);
            if(f1==f2) return;
            if(rank[f1]>rank[f2]){
                parent[f2]=parent[f1];
            }else{
                if(rank[f1]==rank[f2]){
                    rank[f2]++;
                }
                parent[f1]=parent[f2];
            }
            treeNums--;
        }
    }
}