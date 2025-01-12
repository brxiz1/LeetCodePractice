/**
 * @author ZhangYihe
 * @since 2025/1/9
 **/
public class T091 {

}

class Solution91{
    public int numDecodings(String s) {
        int length=s.length();
        int[] nums=new int[length];
        if(s.charAt(0)=='0')return 0;
        nums[0]=1;
        if(length==1)return 1;

        nums[1]=(s.charAt(0)-'0')*10+(s.charAt(1)-'0')<=26?1:0;
        nums[1]+=s.charAt(1)!='0'?1:0;
        for(int i=2;i<length;i++){
            if(s.charAt(i)!='0'){
                nums[i]+=nums[i-1];
            }
            if(s.charAt(i-1)!='0'&&(s.charAt(i-1)-'0')*10+(s.charAt(i)-'0')<=26){
                nums[i]+=nums[i-2];
            }
        }
        return nums[length-1];
    }
}