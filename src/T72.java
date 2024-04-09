public class T72 {


    public static void main(String[] args) {
        Solution72 s72=new Solution72();
        System.out.println(s72.minDistance("horse","ros"));
    }
}
class Solution72 {
    public int minDistance(String word1, String word2) {
        int length1=word1.length();
        int length2=word2.length();
        char[] w1=word1.toCharArray();
        char[] w2=word2.toCharArray();
        int[][] changeStep =new int[length1+1][length2+1];
        //本动态规划解法的迭代方式是十分巧妙的,我还没能理清
        for(int i=0;i<=length1;i++){
            for(int j=0;j<=length2;j++){
                if(i==0)changeStep[i][j]=j;
                else if(j==0)changeStep[i][j]=i;
                else{
                    changeStep[i][j]=Math.min(changeStep[i-1][j]+1,changeStep[i][j-1]+1);
                    if(w1[i-1]==w2[j-1]){
                        changeStep[i][j]=Math.min(changeStep[i][j],changeStep[i-1][j-1]);
                    }else{
                        changeStep[i][j]=Math.min(changeStep[i][j],changeStep[i-1][j-1]+1);
                    }
                }
            }
        }
        return changeStep[length1][length2];
    }
}
