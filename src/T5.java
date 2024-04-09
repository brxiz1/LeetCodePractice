public class T5 {
    public String longestPalindrome(String s) {
        char[] arrays=s.toCharArray();
        int len=s.length();
        int maxLen=1;
        int start=0;
        boolean[][] dp=new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        for(int l=2;l<=len;l++){
            for(int i=0;i<len;i++){
                int j=i+l-1;
                if(j>len-1){
                    break;
                }
                if(arrays[i]==arrays[j]){
                    if(l<=3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }else{
                    dp[i][j]=false;
                }
                if(l>maxLen&&dp[i][j]){
                    maxLen=l;
                    start=i;
                }
            }
        }
        return s.substring(start,maxLen+start);
    }
}
