/**
 * @author ZhangYihe
 * @since 2025/1/19
 **/
public class T132 {
}
class Solution132{
    public int minCut(String s){
        int[][] check=new int[s.length()][s.length()];
        int[] cutNum=new int[s.length()];
        for(int i=1;i<s.length();i++){
            if(check[0][i]==1||isLoop(s,0,i)){
                cutNum[i]=0;
                check[0][i]=1;
            }else{
                int minNum=Integer.MAX_VALUE;
                check[0][i]=-1;
                for(int j=0;j<i;j++){
                    //

                    if(check[j+1][i]==-1)continue;
                    if(check[j+1][i]==1||isLoop(s,j+1,i)){
                        minNum=Math.min(cutNum[j]+1,minNum);
                        check[j+1][i]=1;
                    }else{
                        check[j+1][i]=-1;
                    }
                }
                cutNum[i]=minNum;
            }
        }
        return cutNum[s.length()-1];
    }
    public boolean isLoop(String s,int i,int j){
        if(i==j)return true;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
