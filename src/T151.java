import java.util.Stack;

public class T151 {

}
class Solution151{
    public String reverseWords(String s) {
        Stack<String> stack=new Stack<>();
        char[] str=s.toCharArray();
        int i=0;
        int j=1;
        int length=s.length();
        while(i<length&&j<length){
            if(str[i]==' '){
                i++;
                j=i+1;
                continue;
            }
            if(str[j]!=' '){
                j++;
                continue;
            }
            stack.push(s.substring(i,j));
            i=j+1;
            j=i+1;
        }
        if(i<length&&str[i]!=' '){
            stack.push(s.substring(i,j));
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
            sb.append(" ");
        }
        int sbl=sb.length();
        sb.replace(sbl-1,sbl,"");
        return sb.toString();
    }
}
