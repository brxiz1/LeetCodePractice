import org.w3c.dom.ls.LSOutput;

import java.util.Stack;

public class T20 {


    public static void main(String[] args) {
        Solution20 s20=new Solution20();
        System.out.println(s20.isValid("]"));
    }
}
class Solution20 {
    public boolean isValid(String s) {
        char[] str=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(char c :str){
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else if(c==')'){
                if(stack.empty()||stack.pop()!='('){
                    return false;
                }
            }else if(c==']'){
                if(stack.empty()||stack.pop()!='['){
                    return false;
                }
            }else if(c=='}'){
                if(stack.empty()||stack.pop()!='{') return false;
            }
        }
        return stack.empty();
    }
}
