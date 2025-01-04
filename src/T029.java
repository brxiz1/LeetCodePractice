/**
 * @author ZhangYihe
 * @since 2024/12/31
 **/
public class T029 {
    public static void main(String[] args) {
        Solution29 s29=new Solution29();
        int res=s29.divide(2147483647,1);
        System.out.println(res);
    }
}

class Solution29{
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE){
            if(divisor==-1)return Integer.MAX_VALUE;
            else if(divisor==1)return Integer.MIN_VALUE;
        }

        if(dividend==0)return 0;
        if(divisor==Integer.MIN_VALUE){
            return dividend==Integer.MIN_VALUE?1:0;
        }
        boolean isNegative=dividend>0&&divisor<0||dividend<0&&divisor>0;
        if(divisor>0)divisor=-divisor;
        if(dividend>0)dividend=-dividend;
        if(divisor<dividend)return 0;
        int l=1;
        int r=dividend==Integer.MIN_VALUE?Integer.MAX_VALUE:-dividend;

        //考虑向0截断
        while(l<r){
            //注意这里用l+r的话可能直接超范围
            int m=l+((r-l+1)>>1);

            int sult=quickMultiply(divisor,m,dividend);
            if(sult==0){
                return isNegative?-m:m;
            }else if(sult==1)r=m-1;
            //乘积的绝对值较小，可以保留，这可能导致无限循环
            else l=m;
        }
        int res=l;
//        if(quickMultiply(divisor,res)<dividend)res=res-1;
//        else if(quickMultiply(divisor,res)>dividend)res=res+1;
        if(isNegative)return -res;
        else return res;
    }
    //在乘的过程中直接判断x*y和compare的大小关系，否则因为可能溢出，x*y溢出后无法判断compare==Integer.MIN_VALUE的大小
    //x*y<compare(绝对值大于) 返回1，等于返回0，大于返回-1；
    //事先约定x为负数，y为正数，compare为负数，方便编程
    public int quickMultiply(int x,int y,int compare){
        //要考虑溢出问题
        if(x==0||y==0)return -1;
        if(x==Integer.MIN_VALUE){
            if(y>1)return 1;
            else if(y==1)return Integer.MIN_VALUE<compare?1:0;

        }
        boolean isNegative=true;
        x=Math.abs(x);

        int res=0;

        int mi=y;
        while(x>0){
            //防止res-mi越界
            if(res<compare+mi){
                return 1;
            }
            if((x&1)!=0){
                res-=mi;
            }
            x=x>>1;
            //防止mi+mi越界
            if (x > 0) {
                if(-mi<compare+mi){
                    return 1;
                }
                mi+=mi;
            }

        }

        return Integer.compare(compare, res);
    }
}