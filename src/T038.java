import org.w3c.dom.ls.LSOutput;

/**
 * @author ZhangYihe
 * @since 2025/1/3
 **/
public class T038 {

    public static void main(String[] args) {
        Solution38 s38=new Solution38();
        String res=s38.countAndSay(4);
        System.out.println(res);
    }
}
class Solution38{
    public String countAndSay(int n) {
        String res="1";
        for(int i=0;i<n-1;i++){
            res=RLE(res);
        }
        return res;
    }
    public String RLE(String s){
        int l=s.length();
        StringBuilder sb=new StringBuilder();
        int num=0;
        char ch='@';
        for(int i=0;i<l;i++){
            if(num==0){
                ch=s.charAt(i);
                num++;
                continue;
            }
            if(s.charAt(i)==ch){
                num++;
            }else{
                sb.append(num);
                sb.append(ch);
                num=1;
                ch=s.charAt(i);

            }
        }
        if(num!=0){
            sb.append(num);//注意不能用+号拼接char类型，会被当做int处理
            sb.append(ch);
        }
        return sb.toString();
    }
}