import java.util.Arrays;

/**
 * @author ZhangYihe
 * @since 2024/12/27
 **/
public class T066 {
}

class Solution66{
    public int[] plusOne(int[] digits) {
        int upstate=1;
        for(int i=digits.length-1;i>=0&&upstate==1;i--){
            if(digits[i]==9){
                digits[i]=0;
            }else{
                digits[i]+=upstate;
                upstate=0;
            }
        }
        if(upstate==1){
            int[] res=new int[digits.length+1];
//            int[] res=Arrays.copyOf(digits,digits.length+1);
            res[0]=1;
            System.arraycopy(digits, 0, res, 1, res.length - 1);
            return res;
        }
        return digits;
    }
}