public class T058 {
}
class Solution58{
    public int lengthOfLastWord(String s) {
        int length=s.length();
        int start=-1;
        int end=length;
        for(int i=length-1;i>=0;i--){
            if(end==length&&s.charAt(i)!=' '){
                end=i;
            }
            if(end!=length&&s.charAt(i)==' '){
                start=i;
                break;
            }
        }
        return end-start;
    }
}