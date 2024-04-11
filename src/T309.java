public class T309 {
}
class Solution309{
    //动态规划解题的范例
    //确定状态和状态转移的方法，是解决动态规划问题的关键，本题体现了这一点
    //维护每天的三种状态（即状态转移中不一定只有一种状态），
    // 后一天三种状态的最大收益由前一天的最大收益决定
    public int maxProfit(int[] prices) {
        int dates=prices.length;
        int[][] q=new int[dates][3];
        //0:无票，进入冷静期；1:无票，非冷静；2:有票
        q[0][0]=0;
        q[0][1]=0;
        q[0][2]=-prices[0];
        for(int i=1;i<dates;i++){
            q[i][0]=q[i-1][2]+prices[i];
            q[i][1]=Math.max(q[i-1][0],q[i-1][1]);
            q[i][2]=Math.max(q[i-1][1]-prices[i],q[i-1][2]);
        }
        return Math.max(q[dates-1][0],Math.max(q[dates-1][1],q[dates-1][2]));
    }
}