public class T125 {
    public static void main(String[] args) {
        Solution125 s125=new Solution125();
        boolean s=s125.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(s);
    }
}
class Solution125{
    public boolean isPalindrome(String s) {
        char[] ch=s.toCharArray();
        int length=ch.length;
        int left=0;
        int right=length-1;
        while(left<right){
            if(!Character.isAlphabetic(ch[left])&&!Character.isDigit(ch[left])){
                left++;
                continue;
            }
            if(!Character.isAlphabetic(ch[right])&&!Character.isDigit(ch[right])){
                right--;
                continue;
            }
            if(Character.toLowerCase(ch[left])!=Character.toLowerCase(ch[right])){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
}