/**
 * @author ZhangYihe
 * @since 2024/11/20
 **/
public class T074 {
}
class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length0= matrix.length;
        int length1=matrix[0].length;
        int l=0;
        int r=length0-1;
        int index0;
        while(l<r){
            int mid=(l+r)/2;
            if(matrix[mid][length1-1]<target){
                l=mid+1;
            }else if(matrix[mid][length1-1]==target){
                return true;
            }else{
                r=mid;
            }
        }
        if(matrix[r][length1-1]<target)index0=r+1;
        else if(matrix[r][length1-1]==target)return true;
        else index0=r;
        //考虑到二维数组中所有值均小于target时，index0的取值会==length0
        if(index0>=length0)return false;
        l=0;
        r=length1-1;
        while(l<r){
            int mid=(l+r)/2;
            if(matrix[index0][mid]<target){
                l=mid+1;
            }else if(matrix[index0][mid]==target){
                return true;
            }else{
                r=mid;
            }
        }
        if(matrix[index0][r]==target)return true;
        else return false;
    }
}
