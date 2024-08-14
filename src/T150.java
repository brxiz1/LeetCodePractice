import java.util.Stack;

/**
 * @author ZhangYihe
 * @since 2024/8/14
 **/
public class T150 {
}
class Solution150{
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        for(String s:tokens){
            if("+".equals(s)){
                int i=Integer.parseInt(stack.pop());
                int j=Integer.parseInt(stack.pop());
                stack.push(String.valueOf(i+j));
            }else if("-".equals(s)){
                int i=Integer.parseInt(stack.pop());
                int j=Integer.parseInt(stack.pop());
                stack.push(String.valueOf(j-i));
            }else if("*".equals(s)){
                int i=Integer.parseInt(stack.pop());
                int j=Integer.parseInt(stack.pop());
                stack.push(String.valueOf(i*j));
            }else if("/".equals(s)){
                int i=Integer.parseInt(stack.pop());
                int j=Integer.parseInt(stack.pop());
                stack.push(String.valueOf(j/i));
            }else{
                stack.push(s);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
