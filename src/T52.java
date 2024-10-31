/**
 * @author ZhangYihe
 * @since 2024/10/28
 **/
public class T52 {
    public static void main(String[] args) {
        Solution52 s52=new Solution52();
        int res= s52.totalNQueens(4);
        System.out.println(res);
    }
}
class Solution52{
    int[] column;
    int[] px;//投影：i-j+n-2
    int[] nx;//头硬：i+j-1;

    public int totalNQueens(int n) {
        if(n==1)return 1;
        column=new int[n];
        px=new int[(n-2)*2+1];
        nx=new int[(n-2)*2+1];
        int sum=totalNum(0,n);
        return sum;
    }
    public int totalNum(int index,int n){
        if(index>=n)return 1;
        int sum=0;
        //确定index,i处是否可以放置皇后，
        //判断是否是皇后：在四个角落处，只看column，其余地方，三个均看
        // 若是，则放置，并且search下一行
        for(int i=0;i<n;i++){
            //在四个角部
            if((index==0&&i==0)||(index==n-1&&i==n-1)){
                if(column[i]==0&&px[index-i+n-2]==0){
                    column[i]++;
                    px[index-i+n-2]++;
//                    nx[index+i-1]++;
                    sum+=totalNum(index+1,n);
                    column[i]--;
                    px[index-i+n-2]--;
//                    nx[index+i-1]--;
                }
            }else if((index==n-1&&i==0)||(index==0&&i==n-1)){
                if(column[i]==0&&nx[index+i-1]==0){
                    column[i]++;
//                    px[index-i+n-2]++;
                    nx[index+i-1]++;
                    sum+=totalNum(index+1,n);
                    column[i]--;
//                    px[index-i+n-2]--;
                    nx[index+i-1]--;
                }
            }else if(column[i]==0&&px[index-i+n-2]==0&&nx[index+i-1]==0){
                column[i]++;
                px[index-i+n-2]++;
                nx[index+i-1]++;
                sum+=totalNum(index+1,n);
                column[i]--;
                px[index-i+n-2]--;
                nx[index+i-1]--;
            }
        }

        return sum;
    }
}
//        for(int i=0;i<n;i++){
//        //在四个角部
//        if((index==0&&i==0)||(index==n-1&&i==n-1)){
//        if(column[i]==0&&px[index-i+n-2]==0){
//        column[i]++
//        px[index-i+n-2]++;
////                    nx[index+i-1]++;
//        sum+=totalNum(index+1,n);
//        column[i]--;
//        px[index-i+n-2]--;
////                    nx[index+i-1]--;
//        }
//        }else if((index==n-1&&i==0)||(index==0&&i==n-1)){
//        if(column[i]==0&&nx[index+i-1]==0){
//        column[i]++
////                    px[index-i+n-2]++;
//        nx[index+i-1]++;
//        sum+=totalNum(index+1,n);
//        column[i]--;
////                    px[index-i+n-2]--;
//        nx[index+i-1]--;
//        }
//        }else if(column[i]==0&&px[index-i+n-2]==0&&nx[index+i-1]==0){
//        column[i]++
//        px[index-i+n-2]++;
//        nx[index+i-1]++;
//        sum+=totalNum(index+1,n);
//        column[0]=false;
//        px[index-i+n-2]--;
//        nx[index+i-1]--;
//        }
//        }