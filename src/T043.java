import java.util.Arrays;

/**
 * @author ZhangYihe
 * @since 2025/1/3
 **/
public class T043 {
    public static void main(String[] args) {
        Solution43 s43=new Solution43();
        String res= s43.multiply("0","111111111111111111111111111111111111111");
        System.out.println(res);
    }
}

class Solution43{
    public String multiply(String num1, String num2) {
        char[] res=new char[num1.length()+num2.length()];
        char[] ch1=num1.toCharArray();
        char[] ch2=num2.toCharArray();
        Arrays.fill(res,'0');
        for(int i=0;i<res.length;i++){
            positionSet(res,i,ch1,ch2);
        }
        StringBuilder sb=new StringBuilder();
        boolean frontZeros=true;
        for(int i=0;i<res.length;i++){
            if(frontZeros&&res[i]=='0'){
                continue;
            }else{
                frontZeros=false;
                sb.append(res[i]);
            }
        }
        if(sb.isEmpty()) return "0";
        return sb.toString();

    }
    //数字中的position和char[]中的位置如何对应？0为高位
    public void positionSet(char[] res,int position,char[] ch1,char[] ch2){
        int multiply=0;
        for(int i=0;i<position&&i<ch1.length;i++){
            int j=position-1-i;
            if(j<ch2.length) {

                multiply+=(ch1[i]-'0')*(ch2[j]-'0');
            }
        }
        add(res,position,multiply);

    }

    public void add(char[] res,int index,int addNum){
        while(addNum!=0){
            int a1=res[index]-'0';
            addNum+=a1;
            res[index]= (char) (addNum%10+'0');
            addNum/=10;
            //向高位移动
            index--;
        }
    }
}