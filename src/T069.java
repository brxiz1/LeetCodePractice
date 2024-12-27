/**
 * @author ZhangYihe
 * @since 2024/12/27
 **/
public class T069 {
    public static void main(String[] args) {
        Solution69 solution69=new Solution69();
        int res=solution69.mySqrt(2147395599);
        System.out.println(res);
    }
}

class Solution69{
    public int mySqrt(int x) {
        if(x==0)return 0;
        if(x<4)return 1;
        long left=0;
        long right=x;
        //在快速搜索的过程中，要考虑到left+right>Integer.max和mid*mid>Integer.max的可能
        while(left<right){
            long m=left+right;
            m=(m+1)/2;
            long mid=m;
            if(mid*mid==x){
                return (int)mid;
            }else if(mid*mid>x){
                right=mid-1;
            }else{
                left=mid;
            }
        }
        return (int)left;
    }
}