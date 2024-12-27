/**
 * @author ZhangYihe
 * @since 2024/12/27
 **/
public class T009 {

}

class Solution9{
    public boolean isPalindrome(int x) {
        int reverseHalfNum=0;

        if(x<0||x%10==0&&x!=0)return false;
        while(x>reverseHalfNum){
            reverseHalfNum=reverseHalfNum*10+x%10;
            x=x/10;
        }

        return x==reverseHalfNum||x==reverseHalfNum/10;
    }
}