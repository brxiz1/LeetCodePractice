public class T134 {
    public static void main(String[] args) {
        Solution134 s134=new Solution134();

        int[] gas=new int[]{2,3,4};
        int[] cost=new int[]{3,4,3};
        int res=s134.canCompleteCircuit(gas,cost);
        System.out.println(res);
    }
}
class Solution134{
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length=gas.length;

        int j=0;


        while(true){
            int gasNow=0;
            int lastJ=j;
            boolean canComplete=true;
            for(int i=j;;i=(i+1)%length){
                gasNow+=gas[i];
                if(gasNow<cost[i]){
                    canComplete=false;
                    j=(i+1)%length;
                    break;
                }
                gasNow-=cost[i];
                if(i==(j-1+length)%length)break;
            }
            if(canComplete)return j;
            else if(j<=lastJ)return -1;

        }

    }
}
