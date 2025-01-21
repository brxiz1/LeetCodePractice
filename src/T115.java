/**
 * @author ZhangYihe
 * @since 2025/1/19
 **/
public class T115 {
}
class Solution115{
    public int numDistinct(String s,String t){
        int lenS=s.length();
        int lenT=t.length();
        if(lenS<lenT)return 0;
        long[][] nums=new long[lenS+1][lenT+1];
        for(int i=0;i<=lenS;i++){
            nums[i][lenT]=1;
        }
        for(int i=lenS-1;i>=0;i--){
            for(int j=lenT-1;j>=0;j--){
                if(s.charAt(i)==t.charAt(j)){
                    nums[i][j]=nums[i+1][j+1]+nums[i+1][j];//选择s[i]匹配t[j]，或者不选择
                }else{
                    nums[i][j]=nums[i+1][j];
                }
            }
        }
        return (int) (nums[0][0]%(1000000000+7));
    }
}
