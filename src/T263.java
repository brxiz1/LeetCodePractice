/**
 * @author ZhangYihe
 * @since 2025/2/5
 **/
public class T263 {

}

class Solution263{
    public boolean isUgly(int n) {
        if(n<=0)return false;

        while(n>1){
            if(n%5==0){
                n/=5;
            }else if(n%3==0){
                n/=3;
            }else if(n%2==0){
                n/=2;
            }else{
                return false;
            }
        }
        return true;
    }
}