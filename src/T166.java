import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYihe
 * @since 2025/1/27
 **/
public class T166 {
}

class Solution166{
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0)return "0";
        long num=numerator;
        long deno=denominator;
        StringBuilder sb=new StringBuilder();
        if(num>0&&deno<0||num<0&&deno>0){
            sb.append("-");
        }
        num=Math.abs(num);
        deno=Math.abs(deno);
        long r=num/deno;
        sb.append(r);
        num=num%deno;
        if(num==0)return sb.toString();
        sb.append(".");
        int pointIndex=sb.length()-1;
        Map<Long,Integer> checkMap=new HashMap<>();

        checkMap.put(num,sb.length());
        while(num!=0){
            num*=10;
            r=num/deno;
            num=num%deno;
            sb.append(r);
            if(checkMap.containsKey(num)){
                int loopStartIndex=checkMap.get(num);
                int loopEndIndex=sb.length()-1;
                char[] sequence=new char[loopEndIndex-loopStartIndex+1];
                sb.getChars(loopStartIndex,loopEndIndex+1,sequence,0);
                sb.replace(loopStartIndex,loopEndIndex+1,"");
                sb.append("(");
                sb.append(sequence);
                sb.append(")");
                break;
            }
            checkMap.put(num,sb.length()-1);

        }
        return sb.toString();
    }
}