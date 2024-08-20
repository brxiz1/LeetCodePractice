import java.util.Stack;

/**
 * @author ZhangYihe
 * @since 2024/8/14
 **/
public class T224 {
    public static void main(String[] args) {
        Solution224 s224=new Solution224();
        int res=s224.calculate("-2+ 1");
        System.out.println(res);
    }
}
class Solution224{
    public int calculate(String s) {
        Stack<Integer> numStack=new Stack<>();
        Stack<Character> characterStack=new Stack<>();
        s=s.replaceAll(" ","");
        int length=s.length();
        int index=0;
        numStack.push(0);

        while(index<length){
            String next=nextParam(s,index,length);
            if(next==null)break;

            if(next.equals("+") || next.equals("-")){
                if(index>0&&s.charAt(index-1)=='('){
                    numStack.push(0);
                }
                while(!characterStack.isEmpty()&&characterStack.peek()!='('){
                    char lastChar=characterStack.pop();
                    int num1=numStack.pop();
                    int num2=numStack.pop();
                    if(lastChar=='+'){
                        numStack.push(num1+num2);
                    }else if(lastChar=='-'){
                        numStack.push(num2-num1);
                    }
                }
                characterStack.push(next.charAt(0));
            }else if(next.equals("(")){
                characterStack.push('(');
            }else if(next.equals(")")){
                while(characterStack.peek()!='('){
                    char lastChar=characterStack.pop();
                    int num1=numStack.pop();
                    int num2=numStack.pop();
                    if(lastChar=='+'){
                        numStack.push(num1+num2);
                    }else if(lastChar=='-'){
                        numStack.push(num2-num1);
                    }
                }
                characterStack.pop();
            }else if(next.equals(" ")){
                continue;
            }else{
                numStack.push(Integer.parseInt(next));
            }
            index+=next.length();
        }
        if(characterStack.isEmpty()){
            return numStack.pop();
        }else{
            if(characterStack.pop()=='+'){
                int num1=numStack.pop();
                int num2=numStack.pop();
                return num1+num2;
            }else{
                int num1=numStack.pop();
                int num2=numStack.pop();
                return num2-num1;
            }
        }

    }
    public String nextParam(String s,int index,int length){
        int num=0;
        boolean isNum=false;
        if(index>=length)return null;
        for(int i=index;i<length;i++){
            if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='('||s.charAt(i)==')'){
                break;
            }else if(s.charAt(i)==' '){
                break;
            }else{
                isNum=true;
                num=num*10+(s.charAt(i)-'0');
            }
        }
        if(isNum)return String.valueOf(num);
        else return s.substring(index,index+1);
    }
}
