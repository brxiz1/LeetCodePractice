/**
 * @author ZhangYihe
 * @since 2025/1/5
 **/
public class T059 {

}

class Solution59{
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        setSquare(0,n,res,1);
        return res;
    }

    public void setSquare(int startIndex,int n,int[][] res,int num){
        if(n==0)return;
        if(n==1){
            res[startIndex][startIndex]=num;
            return;
        }
        for(int j=startIndex;j<startIndex+n-1;j++){
            res[startIndex][j]=num++;
        }
        for(int i=startIndex;i<startIndex+n-1;i++){
            res[i][startIndex+n-1]=num++;
        }
        for(int j=startIndex+n-1;j>startIndex;j--){
            res[startIndex+n-1][j]=num++;
        }
        for(int i=startIndex+n-1;i>startIndex;i--){
            res[i][startIndex]=num++;
        }
        setSquare(startIndex+1,n-2,res,num);
    }
}
