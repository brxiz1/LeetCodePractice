import java.util.ArrayList;
import java.util.List;

public class T438 {
    public static void main(String[] args) {
        Solution438 s438=new Solution438();
        List<Integer> list=s438.findAnagrams("abab","ab");
        System.out.println(list);
    }
}
class Solution438{
    public List<Integer> findAnagrams(String s, String p) {
        int[] wordList=new int[26];
        int cwds=p.length();
        for(int i=0;i<cwds;i++){
            char ch=p.charAt(i);
            wordList[ch-'a']+=1;
        }
        int length=s.length();
        if(cwds>length){
            return new ArrayList<>();
        }
        for(int i=0;i<26;i++){
            if(wordList[i]==0){
                wordList[i]=Integer.MIN_VALUE;
            }
        }

        int left=0;
        int right=cwds-1;
        boolean isZero=false;
        for(int i=0;i<=right;i++){
            char ch=s.charAt(i);
            if(wordList[ch-'a']!=Integer.MIN_VALUE){
                wordList[ch-'a']--;
            }
            if(wordList[ch-'a']==0){
                isZero=true;
            }
        }
        List<Integer> res=new ArrayList<>();
        for(;right<length;){
            if(isZero&&isFind(wordList)){
                res.add(left);
            }
            isZero=false;
            //移动左指针

            left++;
            char l=s.charAt(left-1);
            if(wordList[l-'a']!=Integer.MIN_VALUE){
                wordList[l-'a']++;
            }
            if(wordList[l-'a']==0){
                isZero=true;
            }
            //移动右指针
            right++;
            if(right>=length){
                break;
            }
            char r=s.charAt(right);
            if(wordList[r-'a']!=Integer.MIN_VALUE){
                wordList[r-'a']--;
            }
            if(wordList[r-'a']==0){
                isZero=true;
            }
        }
        return res;
    }
    public boolean isFind(int[] wordlist){
        for(int i:wordlist){
            if(i!=0&&i!=Integer.MIN_VALUE){
                return false;
            }
        }
        return true;
    }
}
