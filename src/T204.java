import java.util.Arrays;

/**
 * @author ZhangYihe
 * @since 2025/1/31
 **/

public class T204 {

}
//埃氏筛算法,如果一个数是质数，那么他的倍数一定是合数，另外，所有合数都一定是某个质数的倍数
class Solution204{
    boolean[] isPrime;
    public int countPrimes(int n) {
        if(n==1||n==0)return 0;
        isPrime=new boolean[n];
        Arrays.fill(isPrime,true);
        int nums=0;
        //只考虑小于n的数
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                nums++;
                for(int j=i;i<Integer.MAX_VALUE/j&&j*i<n;j++){
                    isPrime[j*i]=false;
                }
            }
        }
        return nums;
    }
//    public boolean isPrime(int num){
//        if(!isPrime[num]){
//            return false;
//        }
//        int sqn=(int)Math.sqrt(num);
//        for(int i=2;i<=sqn;i++){
//            if(num%sqn==0)return false;
//        }
//        return true;
//    }
}