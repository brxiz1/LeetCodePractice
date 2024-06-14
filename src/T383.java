public class T383 {
}
class Solution383{
    public boolean canConstruct(String ransomNote, String magazine) {
        int lengthR=ransomNote.length();
        int lengthM=magazine.length();
        int[] chNums=new int[26];
        for(int i=0;i<lengthM;i++){
            chNums[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<lengthR;i++){
            chNums[ransomNote.charAt(i)-'a']--;
            if(chNums[ransomNote.charAt(i)-'a']<0)return false;
        }
        return true;
    }
}