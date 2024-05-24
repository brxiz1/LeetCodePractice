public class T647 {
    public static void main(String[] args) {
        Solution647 s647=new Solution647();
        int res=s647.countSubstrings("aaa");
        System.out.println(res);
    }
}
class Solution647{
    public int countSubstrings(String s) {
        char[] ctrs=s.toCharArray();
        int length=ctrs.length;
        int sum=0;
        for(int i=0;i<length;i++){
            sum++;
            for(int j=1;j<=length/2;j++){
                if(i-j<0)break;
                if(i+j>=length) break;
                if(ctrs[i-j]==ctrs[i+j]){
                    sum++;
                }else break;
            }
        }
        for(int i=0;i<length-1;i++){
            if(ctrs[i]==ctrs[i+1]){
                sum++;
            }else{
                continue;
            }
            for(int j=1;j<length/2;j++){
                if(i-j<0)break;
                if(i+j+1>=length)break;
                if(ctrs[i-j]==ctrs[i+j+1])sum++;
                else break;
            }
        }
        return sum;
    }
}