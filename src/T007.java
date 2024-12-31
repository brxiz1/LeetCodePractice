/**
 * @author ZhangYihe
 * @since 2024/12/29
 **/
public class T007 {
    public static void main(String[] args) {
        Solution007 s007=new Solution007();
        int res=s007.reverse(1534236469);
        System.out.println(res);
    }
}

class Solution007{
    public int reverse(int x) {
        boolean isNegative=x<0;
        int res=0;
        if(x==Integer.MIN_VALUE)return 0;
        //对x取绝对值时要考率Integer.MIN_VALUE的绝对值会溢出
        x=Math.abs(x);

        while(x!=0){
            if((double)Integer.MAX_VALUE/10-res<(double)x%10/10&&!isNegative||isNegative&&res>1&&(double)Integer.MAX_VALUE/10-res+0.1<(double)x%10/10){
                return 0;
            }
            res=res*10+x%10;
            x/=10;
        }
        if(isNegative)res*=-1;
        return res;
    }
}