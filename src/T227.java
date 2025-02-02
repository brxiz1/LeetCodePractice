import java.util.Stack;

/**
 * @author ZhangYihe
 * @since 2025/2/2
 **/
public class T227 {
    public static void main(String[] args) {
        Solution227 s227=new Solution227();
        String s="1+2*5/3+6/4*2";
        int res= s227.calculate(s);

    }
}

class Solution227{
    public int calculate(String s) {
        s=s.replace(" ","");
        Stack<Integer> numStack=new Stack<>();
        int length=s.length();
        int num=0;
        char lastCh='+';
        for(int i=0;i<length;i++){
            char c1=s.charAt(i);
            if(c1>='0'&&c1<='9'){
                num=num*10+c1-'0';
            }else{
                switch(lastCh){
                    case '+':numStack.push(num);break;
                    case '-':numStack.push(-num);break;
                    case '*':{
                        numStack.push(numStack.pop()*num);
                        break;
                    }
                    default:{
                        numStack.push(numStack.pop()/num);
                    }
                }
                num=0;
                lastCh=c1;
            }
        }
        switch(lastCh){
            case '+':numStack.push(num);break;
            case '-':numStack.push(-num);break;
            case '*':{
                numStack.push(numStack.pop()*num);
                break;
            }
            default:{
                numStack.push(numStack.pop()/num);
            }
        }
        int res=0;
        while(!numStack.isEmpty()){
            res+=numStack.pop();
        }
        return res;
    }

    public int getRes(int n1,int n2,char ch){
        return switch (ch) {
            case '+' -> n1 + n2;
            case '-' -> n1 - n2;
            case '*' -> n1 * n2;
            case '/' -> n1 / n2;
            default -> -1;
        };
    }

    public boolean getPriority(char ch1,char ch2){
        int p1=0;
        int p2=0;
        p1=switch(ch1){
            case '+'->0;
            case '-'->1;
            case '*'->2;
            case '/'->2;
            default -> -1;
        };
        p2=switch(ch2){
            case '+'->0;
            case '-'->1;
            case '*'->2;
            case '/'->2;
            default -> -1;
        };
        return p1>p2;
    }


}
