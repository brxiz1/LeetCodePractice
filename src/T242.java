public class T242 {

}
class Solution242{
    public boolean isAnagram(String s, String t) {
        int[] charCount=new int[26];
        int length=s.length();
        if(length!=t.length())return false;
        for(int i=0;i<length;i++){
            charCount[s.charAt(i)-'a']++;
        }
        for(int i=0;i<length;i++){
            charCount[t.charAt(i)-'a']--;
            if(charCount[t.charAt(i)-'a']<0)return false;
        }
        for(int count:charCount){
            if(count!=0)return false;
        }
        return true;
    }
}