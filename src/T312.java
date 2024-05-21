public class T312 {
    public static void main(String[] args) {
        Solution312 s312=new Solution312();
        System.out.println(s312.maxCoins(new int[]{1,5}));
    }
}

class Solution312{
    public int maxCoins(int[] nums) {
        int[] newNums=new int[nums.length+2];
        for(int i=1;i<newNums.length-1;i++){
            newNums[i]=nums[i-1];
        }
        int length= newNums.length;
        newNums[0]=1;
        newNums[length-1]=1;
        int[][] reward=new int[length-1][length];
        for(int l=3;l<=length;l++){
            for(int i=0;i<length-1;i++){
                if(i+l-1>length-1)break;
                int re=0;
                for(int k=i+1;k<i+l-1;k++){
                    re=Math.max(re,reward[i][k]+
                            newNums[i]*newNums[k]*newNums[i+l-1]+
                            reward[k][i+l-1]);
                }
                reward[i][i+l-1]=re;
            }
        }
        return reward[0][length-1];
    }
}