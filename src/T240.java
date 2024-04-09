public class T240 {

}
class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int y=0;
        int x=matrix[0].length-1;
        while(x>=0&&y<matrix.length){
            if(matrix[y][x]==target){
                return true;
            }else if(matrix[y][x]>target){
                x--;
            }else{
                y++;
            }
        }
        return false;
    }
}