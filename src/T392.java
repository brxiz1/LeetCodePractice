public class T392 {
}
class Solution392{
    public boolean isSubsequence(String s, String t) {
        int lengthT=t.length();
        int[][] dp=new int[lengthT+1][26];
        for(int i=0;i<26;i++){
            dp[lengthT][i]=-1;
        }
        for(int i=lengthT-1;i>=0;i--){
            for(int j=0;j<26;j++){
                dp[i][j]=t.charAt(i)=='a'+j?i:dp[i+1][j];
            }
        }
        int indexT=0;
        for(int i=0;i<s.length();i++){
            int newIndexT=dp[indexT][s.charAt(i)-'a'];
            if(newIndexT==-1)return false;
            indexT=newIndexT+1;
//            if(newIndexT==indexT){
//                indexT=dp[indexT+1][s.charAt(i)-'a'];
//            }else{
//                indexT=newIndexT;
//            }
        }
        return true;
    }
}