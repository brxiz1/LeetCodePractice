import java.util.Arrays;

public class T48 {
    public static void main(String[] args) {
        Solution48 s48=new Solution48();
        int[][] matrix=new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        s48.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
class Solution48 {
    public void rotate(int[][] matrix) {
        int length=matrix.length;
//        ring(matrix,0,0,length);
        for(int i=0;i<(length+1)/2;i++){//注意（length+1）/2这种格式，它使得奇数行能访问到中间列，但不影响偶数行对前半数组的访问
            for(int j=0;j<length/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[length-j-1][i];
                matrix[length-j-1][i]=matrix[length-i-1][length-j-1];
                matrix[length-i-1][length-j-1]=matrix[j][length-i-1];
                matrix[j][length-i-1]=temp;//循环赋值，只用一个多余位而进行了多次赋值
            }
        }
    }
//    public void ring(int[][] matrix,int index,int j,int length){
//        if(index>=length/2||index!=j) return;
//        for(int i=index;i<length-index;i++){
//
//
//        }
//    }
}