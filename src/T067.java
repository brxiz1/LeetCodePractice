/**
 * @author ZhangYihe
 * @since 2024/12/27
 **/
public class T067 {


    public static void main(String[] args) {
        Solution67 s67=new Solution67();
        String res=s67.addBinary("11","1");
        System.out.println(res);
    }
}
class Solution67{
    public String addBinary(String a, String b) {
//        char[] actrs=a.toCharArray();
//        char[] bctrs=b.toCharArray();
        int al=a.length(),bl=b.length();
        char[] actrs=null;
        char[] bctrs=null;
        if(al>bl){
            actrs=a.toCharArray();
            bctrs=new char[al];
            for(int i=0;i<al;i++){
                if(i<al-bl){
                    bctrs[i]='0';
                }else{
                    bctrs[i]=b.charAt(i-(al-bl));
                }
            }
        }else if(bl>al){
            bctrs=b.toCharArray();
            actrs=new char[bl];
            for(int i=0;i<bl;i++){
                if(i<bl-al){
                    actrs[i]='0';
                }else{
                    actrs[i]=a.charAt(i-(bl-al));
                }
            }
        }else{
            actrs=a.toCharArray();
            bctrs=b.toCharArray();
        }
        StringBuilder sb=new StringBuilder();
        boolean upstate=false;
        for(int i=Math.max(al,bl)-1;i>=0;i--){
            char a1=actrs[i];
            char b1=bctrs[i];
            if(a1=='1'&&b1=='1'){
                sb.append(upstate?'1':'0');
                upstate=true;
            }else if(a1=='0'&&b1=='1'||a1=='1'&&b1=='0'){
                sb.append(upstate?'0':'1');
            }else{
                sb.append(upstate?'1':'0');
                upstate=false;
            }
        }
        if(upstate)sb.append('1');
        String s=sb.reverse().toString();
        return s;

    }

    public String addBinary2(String a,String b){
        int al=a.length();
        int bl=b.length();
        char[] actrs=a.toCharArray();
        char[] bctrs=b.toCharArray();
        int upstate=0;
        StringBuilder sb=new StringBuilder();
        for(int i=al-1,j=bl-1;i>=0||j>=0;i--,j--){
            int res=upstate;
            res+=i>=0?actrs[i]-'0':0;
            res+=j>=0?bctrs[j]-'0':0;
            sb.append(res%2);
            upstate=res>>1;
        }
        if(upstate>0){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}