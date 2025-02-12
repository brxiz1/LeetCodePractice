import java.util.*;

/**
 * @author ZhangYihe
 * @since 2025/2/5
 **/
public class T267 {
    public static void main(String[] args) {
        Solution267 s267=new Solution267();
        List<String> res=s267.generatePalindromes("aabbcc");
        System.out.println(res);
    }
}
class Solution267{
    Set<String> set=new HashSet<>();
    int length;
    char addCh=(char)0;
    public List<String> generatePalindromes(String s) {
        int[] letterNums=new int[26];
        length=s.length()/2;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            letterNums[ch-'a']++;
        }
        int count=0;

        for(int i=0;i<26;i++){
            if(letterNums[i]%2==1){
                count++;
                addCh=(char)(i+'a');
            }
        }
        if(count>1)return new ArrayList<>();
        //多出来的一个字符要放在中间
        for(int i=0;i<26;i++){
            letterNums[i]/=2;
        }
        searchAndCreatePalindromes(new StringBuilder(),letterNums);

        return new ArrayList<>(set);
    }
    public void searchAndCreatePalindromes(StringBuilder sb,int[] letterNums){
        if(sb.length()==length){
            if(addCh==(char)0){
                StringBuilder nsb=new StringBuilder(sb);
                nsb.reverse();
                String s= sb.toString() +nsb.toString();
                set.add(s);
            }else{

                StringBuilder nsb=new StringBuilder(sb);
                nsb.reverse();
                String s=sb.toString()+addCh+nsb.toString();
                set.add(s);
            }

            return;
        }
        for(int i=0;i<26;i++){
            if(letterNums[i]>0){
                sb.append((char)(i+'a'));
                letterNums[i]--;
                searchAndCreatePalindromes(sb,letterNums);
                letterNums[i]++;
                sb.delete(sb.length()-1,sb.length());
            }
        }
    }
}