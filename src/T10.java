import org.w3c.dom.ls.LSOutput;

public class T10 {
    public static void main(String[] args) {
        Solution10 s10=new Solution10();
        System.out.println(s10.isMatch("aa" ,".*"));
    }

}
class Solution10 {
    public boolean isMatch(String s, String p) {
        int lengths=s.length();
        int lengthp=p.length();
        char[] chars=s.toCharArray();
        char[] charp=p.toCharArray();
        boolean[][] match=new boolean[lengths+1][lengthp+1];
        match[0][0]=true;
        for(int i=0;i<=lengths;i++){
            for(int j=1;j<=lengthp;j++){
                if(charp[j-1]=='*'&&j!=1){
                    if(i!=0&&(charp[j-2]==chars[i-1]||charp[j-2]=='.')){
                        match[i][j]=match[i][j-2]||match[i-1][j];//match[3][2]==match[3][0]||match[2][2]
                    }else{
                        match[i][j]=match[i][j-2];
                    }
                }else{
                    if(i==0){
                        match[i][j]=false;
                        continue;
                    }
                    if(i!=0&&(chars[i-1]==charp[j-1]||charp[j-1]=='.')){
                        match[i][j]=match[i-1][j-1];
                    }
                }
                //这里要注意严格按照转移方程确定判断顺序，这将明显影响判断结果
//                if(i==0){
//                    match[i][j]=false;
//                    continue;
//                }




            }
        }
        return match[lengths][lengthp];
    }
}
