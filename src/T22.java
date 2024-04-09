import java.util.ArrayList;
import java.util.List;

public class T22 {
    public static void main(String[] args) {
        Solution22 s22=new Solution22();
        System.out.println(s22.generateParenthesis(0));
    }
}
//深度优先遍历
class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> Collections=new ArrayList<>();
        StringBuilder coll=new StringBuilder();
        if(n==0) return Collections;
        int left=n;
        int right=n;
        createCollections(Collections,coll,left,right);
        return Collections;
    }

    public void createCollections(List<String> Collections,StringBuilder coll,int left,int right){
        if(left==0&&right==0){
            Collections.add(String.valueOf(coll));
            return;
        }
        if(left>right) return;
        if(left>0){
            coll.append('(');
            createCollections(Collections,coll,left-1,right);
            coll.deleteCharAt(coll.length()-1);
        }
        if(right>left){
            coll.append(')');
            createCollections(Collections,coll,left,right-1);
            coll.deleteCharAt(coll.length()-1);
        }
    }
}
