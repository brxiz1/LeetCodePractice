public class T122 {

}
class Solution122{
    //动态优化的办法
    public int maxProfit(int[] prices) {
        int length=prices.length;
        int[][] dp=new int[length][2];//0有股票，1没股票
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for(int i=1;i<length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return Math.max(dp[length-1][0],dp[length-1][1]);
    }

    //贪心算法
    //在每一个即将上涨的交易日买入，第二天卖出
    //反证法证明贪心算法的正确性
/*假设 「贪心算法」 得到的解并不是最优解，即我们还能够找到一个可行解比 「贪心算法」 得到的利润还多。差分数组中除了差分为正数的项以外，还有就是差分为 000 的项与差分为负数的项。「贪心算法」 是所有差分为正数的项的和。有以下 333 种情况：

如果可行解在 「贪心算法」 的基础上，选择了差分为 000 的项,
得到的结果与「贪心算法」得到的结果一样，因此加上差分为 000 的项不会比「贪心算法」得到的结果更好；
如果可行解在 「贪心算法」 的基础上，选择了差分为负数的项，
加上一个负数得到的结果一定比 「贪心算法」 得到的结果要少，加上差分为负数的项，一定比 「贪心算法」 得到的结果更少；
如果可行解在 「贪心算法」 的基础上，去掉了任何一个差分为正数的项
，同上，得到的结果一定比 「贪心算法」 得到的结果要小，因此，「贪心算法」 的所有组成项不能删去任何一个。

    * */
    public int maxProfit2(int[] prices){
        int length=prices.length;
        int maxProfit=0;
        for(int i=0;i<length-1;i++){
            if(prices[i+1]>prices[i]){
                maxProfit+=prices[i+1]-prices[i];
            }
        }
        return maxProfit;
    }
}