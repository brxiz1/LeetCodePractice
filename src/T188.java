import java.util.Arrays;

/**
 * @author ZhangYihe
 * @since 2024/12/29
 **/
public class T188 {

}

class Solution188{
    public int maxProfit(int k, int[] prices) {
        if(prices.length<2)return 0;
        k=Math.min(k,prices.length/2);
        int[] buys=new int[k];
        Arrays.fill(buys,Integer.MIN_VALUE);
        int[] sells=new int[k];
        for(int price:prices){
            sells[0]=Math.max(sells[0],buys[0]+price);
            buys[0]=Math.max(buys[0],0-price);
            for(int i=1;i<k;i++){
                if(sells[i-1]!=0){
                    sells[i]=Math.max(buys[i]+price,sells[i]);
                    buys[i]=Math.max(buys[i],sells[i-1]-price);
                }
            }
        }
        int maxAward=0;
        for(int i=0;i<k;i++){
            maxAward=Math.max(sells[i],maxAward);
        }
        return maxAward;
    }
}