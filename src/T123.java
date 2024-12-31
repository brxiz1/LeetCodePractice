/**
 * @author ZhangYihe
 * @since 2024/12/29
 **/
public class T123 {
    public static void main(String[] args) {
        Solution123 s123=new Solution123();
        int[] prices=new int[]{1, 2, 3, 4, 5};
        System.out.println(s123.maxProfit(prices));;
    }
}
//股票交易类问题当前状态的确定往往依赖于上一次交易日，
// 而不是直接的上一日，因此确定状态转移方程和各个状态时，
// 应更关注交易的完成情况
class Solution123{
    public int maxProfit(int[] prices) {
        int noAction=0;
        int buy1=Integer.MIN_VALUE;
        int sell1=0;
        int buy2=Integer.MIN_VALUE;
        int sell2=0;
        for(int p:prices){

            if(sell1!=0){
                sell2=Math.max(sell2,buy2+p);
                buy2=Math.max(buy2,sell1-p);
            }
            sell1=Math.max(sell1,buy1+p);
            buy1=Math.max(buy1,noAction-p);

        }
        return Math.max(sell1,sell2);
    }
}