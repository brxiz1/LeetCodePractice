public class T64 {
    public static void main(String[] args) {
        Solution64 s64=new Solution64();
        System.out.println(s64.minPathSum(new int[][]{
                {1,3,1},{1,5,1},{4,2,1}
        }));
    }

}
class Solution64 {
    public int minPathSum(int[][] grid) {
        int length1= grid.length;;
        int length2=grid[0].length;
        System.out.println(length2);
        for(int i=0;i<length1;i++){
            for(int j=0;j<length2;j++){
                if(i==0&&j==0){
                    continue;
                }
                if(i==0){
                    grid[i][j]+=grid[i][j-1];
                }
                else if(j==0){
                    grid[i][j]+=grid[i-1][j];
                }
                else {
                    grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[length1-1][length2-1];
    }
}