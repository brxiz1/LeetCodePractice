import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYihe
 * @since 2024/12/28
 **/
public class T149 {
    public static void main(String[] args) {
        Solution149 s149=new Solution149();
        int[][] points=new int[][]{{1,1}, {2,2}, {3,3}};
        int res=s149.maxPoints(points);
        System.out.println(res);
    }
}
class Solution149{
    //计算每个点到其它点的斜率，
    // 如果相同，意味着这几个点在同一条过该点的直线上
    //不用double型记录斜率，因为存在误差，
    // 用分子和分母记录，然后通过乘法判断斜率是否相当
    //要注意按照题目要求理解二维数组的格式
    public int maxPoints(int[][] points) {
        int l1=points.length;
        int l2=points[0].length;
        //如果少于两个点，直接返回
        if(l1<2)return l1;
        int max=0;
        for(int i1=0;i1<l1;i1++){

                int x1=points[i1][0];
                int y1=points[i1][1];
                //斜率map
                Map<String,Integer> map=new HashMap<>();
                for(int i2=i1+1;i2<l1;i2++){


                        int x2=points[i2][0];
                        int y2=points[i2][1];
                        //计算斜率
                        int mx=x1-x2;
                        int my=y1-y2;
                        //默认my为正
                        if(y1-y2<0){
                            mx=-mx;
                            my*=-1;
                        }
                        if(x1-x2==0){
                            map.put("0",map.getOrDefault("0",1)+1);
                            continue;
                        }
                        if(y1-y2==0){
                            map.put("1",map.getOrDefault("1",1)+1);
                            continue;
                        }
                        int gcd=gcd(mx,my);
                        mx/=gcd;
                        my/=gcd;
                        String key=mx+"&"+my;
                        map.put(key,map.getOrDefault(key,1)+1);

                }
                for(String k:map.keySet()){
                    max=Math.max(max,map.get(k));
                }
                if(max>l1*l2/2)return max;

        }
        return max;
    }

    public int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }

}