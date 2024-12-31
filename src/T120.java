import java.util.List;

/**
 * @author ZhangYihe
 * @since 2024/12/29
 **/
public class T120 {
}

class Solution120{
    public int minimumTotal(List<List<Integer>> triangle) {
        int high=triangle.size();
        int[] pathValue=new int[high];
        pathValue[0]=triangle.get(0).get(0);
        for(int i=1;i<high;i++){
             int width=triangle.get(i).size();
            pathValue[width-1]=pathValue[width-2]+triangle.get(i).get(width-1);
            for(int j=width-2;j>=1;j--){
                pathValue[j]=Math.min(pathValue[j],pathValue[j-1])+triangle.get(i).get(j);
            }
            pathValue[0]=pathValue[0]+triangle.get(i).get(0);
        }
        int res=Integer.MAX_VALUE;
        for(int n:pathValue){
            res=Math.min(n,res);
        }
        return res;
    }
}