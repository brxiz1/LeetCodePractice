/**
 * @author ZhangYihe
 * @since 2025/1/27
 **/
public class T171 {
}

class Solution171{
    public int titleToNumber(String columnTitle) {
        int length=columnTitle.length();
        int res=0;
        int multiply=1;
        for(int i=length-1;i>=0;i--){
            res+=multiply*(columnTitle.charAt(i)-'A'+1);
            multiply*=26;
        }
        return res;
    }
}