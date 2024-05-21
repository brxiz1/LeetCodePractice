import java.util.Arrays;

public class T322 {
    public static void main(String[] args) {
        Solution322 s322=new Solution322();
        System.out.println(s322.coinChange(new int[]{186,419,83,408},6249));
    }
}
//记忆化的深度优先搜索；试图通过排序做剪枝，但没有成功，不知道为什么
//也可以完全通过动态优化实现
class Solution322{
    public int coinChange(int[] coins, int amount) {
        int[] ways=new int[amount+1];
//        Arrays.sort(coins);
        if(amount==0) return 0;
//        dps(amount,ways,coins,coins.length-1);
        dps(amount,ways,coins);
        if(ways[amount]==Integer.MAX_VALUE)return -1;
        return ways[amount];
    }
    public void dps(int amount,int[] ways,int[] coins){
        int lessways=Integer.MAX_VALUE;
        for(int i=coins.length-1;i>=0;i--){
            if(amount-coins[i]>0){
                if(ways[amount-coins[i]]==0){
                    dps(amount-coins[i],ways,coins);
                }
                if(ways[amount-coins[i]]==Integer.MAX_VALUE){
                    continue;
                }
                lessways=Math.min(lessways,ways[amount-coins[i]]+1);
            }else if(amount==coins[i]){
                lessways=1;
                break;
            }
        }

        ways[amount]=lessways;
    }
}