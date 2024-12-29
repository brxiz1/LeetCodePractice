/**
 * @author ZhangYihe
 * @since 2024/12/28
 **/
public class T050 {
    public static void main(String[] args) {
        Solution50 s50=new Solution50();
        double s=s50.myPow(2,-2147483648);
        System.out.println(s);
    }
}

class Solution50{
    //如果n是2的幂，就可以快速迭代得到
    //求x的n次方，最快的方法是不断的求平方来快速达到，
    //将n用二进制解析可得n=2^0+2^1+...,故x^n=x^1*x^2*...
    public double myPow(double x, int n) {
        if(n==Integer.MIN_VALUE){
            if(x==1||x==0){
                return x;
            }else if(x==-1){
                return 1;

            }else{
                return 0;
            }
        }
        if(n<0){
            x=1/x;
            n=-n;
        }

        double res=1;
        double before=x;
//        int position=0;
        while(n>0){
            int mi=n%2;
            n=n/2;
            if(mi==1){
                res*=before;
            }
            before*=before;
//            position++;
        }
        return res;
    }
}