import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T301 {
    public static void main(String[] args) {
        Solution301 s301=new Solution301();
        System.out.println(s301.removeInvalidParentheses("()())()"));
    }
}
class Solution301 {
    //广度优先遍历，生成了每一种删除的可能性，每删一次算作一层，记录一次
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set=new HashSet<>();
        List<String> res=new ArrayList<>();
        set.add(s);
        int length=s.length();
        while(true){
            for(String str:set){
                if(isRes(str)){
                    res.add(str);
                }
            }
            if(!res.isEmpty()){
                break;
            }
            Set<String> newSet=new HashSet<>();
            for(String str:set){
                for(int i=0;i<length;i++){
                    newSet.add(str.substring(0,i)+str.substring(i+1));
                }
            }
            length--;
            set=newSet;
        }
        return res;

    }
    public boolean isRes(String s){
        int left=0;
        char[] ch=s.toCharArray();
        for (char c : ch) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                left--;
            }
            if (left < 0) {
                return false;
            }
        }
        return left==0;
    }
}