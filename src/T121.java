public class T121 {
}
class Solution121 {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int maxValue=0;
        for(int i:prices){
            if(min>i) min=i;
            else if(i-min>maxValue) maxValue=i-min;
        }
        return maxValue;
    }

}