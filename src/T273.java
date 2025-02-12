import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYihe
 * @since 2025/2/5
 **/
public class T273 {
}

class Solution273{
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        String[] res=new String[4];
        int multi=1000000000;
        if(num==0)return "Zero";
        for(int i=0;i<4;i++,multi/=1000){
            int n=num/multi;
            if(n==0)continue;
            StringBuilder sb=new StringBuilder();
            if(n>=100){
                sb.append(singles[n/100]).append(" Hundred ");
                n=n%100;
            }
            if(n>=20){
                sb.append(tens[n/10]).append(" ");
                n%=10;
            }else if(n>=10&&n<20){
                sb.append(teens[n-10]).append(" ");
                n=0;
            }
            if(n!=0){

                sb.append(singles[n]).append(" ");
            }

            res[i]=sb.toString();
            num%=multi;
        }
        StringBuilder r= new StringBuilder();
        for(int i=0;i<3;i++){
            if(res[i]==null)continue;
            r.append(res[i]).append(thousands[3 - i]).append(" ");
        }
        if(res[3]!=null){
            r.append(res[3]);
        }


        return r.toString().strip();
    }
}