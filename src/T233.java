/**
 * @author ZhangYihe
 * @since 2025/2/3
 **/
public class T233 {
}

class Solution233{
    public int countDigitOne(int n) {
        int k=1;
        int res=0;
        while(n/k>0){
            res+=(n/k/10)*k+Math.min(k,Math.max(n%(10*k)-k+1,0));
            k*=10;
        }
        return res;
    }
}