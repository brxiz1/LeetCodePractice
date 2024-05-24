public class T621 {
    public static void main(String[] args) {
        Solution621 s621=new Solution621();
        int res=s621.leastInterval(new char[]{'A','A','A','B','B','B','C','D','E','F','G','H','I','J','K'},7);
        System.out.println(res);
    }
}
class Solution621{
    public int leastInterval(char[] tasks, int n) {
        int[] cdList=new int[26];
        int[] nums=new int[26];
        int length=tasks.length;
        for(int i=0;i<26;i++){
            cdList[i]=Integer.MAX_VALUE;
        }
        for(char ch:tasks){
            nums[ch-'A']++;
            cdList[ch-'A']=0;
        }
        int turn=0;
        while(true){
            int nextNo=26;
            int maxNum=0;
            int nextTurn=Integer.MAX_VALUE;
            boolean notAllCd=false;
            for(int i=0;i<26;i++){
                if(nums[i]==0) continue;
                if(cdList[i]<=turn){
                    notAllCd=true;
                    if(nums[i]>maxNum){
                        nextNo=i;
                        maxNum=nums[i];
                    }
                }else{
                    nextTurn=Math.min(nextTurn,cdList[i]);
                }

            }

            if(!notAllCd){
                turn=nextTurn;
                continue;
            }
            turn++;
            nums[nextNo]--;
            cdList[nextNo]=turn+n;
            boolean isFinish=true;

            for(int i:nums){
                if (i > 0) {
                    isFinish = false;
                    break;
                }
            }
            if(isFinish){
                break;
            }
        }
        return turn;
    }
}
