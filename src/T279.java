public class T279 {

}

class Solution279 {
    //动态规划的方法
    public int numSquares(int n) {
        int[] numsi2=new int[n+1];

        for(int i=1;i<=n;i++){
            int minNums=Integer.MAX_VALUE;
            int sqrt= (int) Math.sqrt(i);
            for(int j=1;j<=sqrt;j++){
                minNums=Math.min(minNums,numsi2[i-j*j]);
            }
            numsi2[i]=1+minNums;
        }
        return numsi2[n];
    }
}