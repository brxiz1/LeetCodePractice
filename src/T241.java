import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/2/3
 **/
public class T241 {


    public static void main(String[] args) {
        Solution241 solution241=new Solution241();
        List<Integer> res=solution241.diffWaysToCompute("2-1-1");
        System.out.println(res);
    }
}
class Solution241{
    public List<Integer> diffWaysToCompute(String expression) {


        List<Integer> expList=new ArrayList<>();

        int expLength=expression.length();

        int num=0;
        for(int i=0;i<expLength;i++){
            char ch=expression.charAt(i);
            if(Character.isDigit(ch)){
                num=num*10+ch-'0';
            }else{
                expList.add(num);
                num=0;
                int chn=switch(ch){
                    case '+'->-1;
                    case '-'->-2;
                    case '*'->-3;
                    default -> -4;
                };
                expList.add(chn);
            }
        }
        expList.add(num);
        List<Integer>[][] res=new List[expList.size()][expList.size()];
        List<Integer> rl=searchRes(expList,res,0,expList.size()-1);
        return rl;

    }
    public List<Integer> searchRes(List<Integer> expList,List<Integer>[][] res,int l,int r){
        if(res[l][r]!=null)return res[l][r];
        if(l==r){
            List<Integer> rl=Collections.singletonList(expList.get(l));
            res[l][r]=rl;
            return rl;
        }
        //以l到r间的每一个运算符求左右两侧的res，并计算得到本位置的res
        List<Integer> nl=new ArrayList<>();
        for(int i=l+1;i<r;i+=2){
            List<Integer> ll=searchRes(expList,res,l,i-1);
            List<Integer> rl=searchRes(expList,res,i+1,r);

            switch(expList.get(i)){
                case -1:{
                    for(int ln:ll){
                        for(int rn:rl){
                            nl.add(ln+rn);
                        }
                    }
                    break;
                }
                case -2:{
                    for(int ln:ll){
                        for(int rn:rl){
                            nl.add(ln-rn);
                        }
                    }
                    break;
                }
                default:{
                    for(int ln:ll){
                        for(int rn:rl){
                            nl.add(ln*rn);
                        }
                    }
                    break;
                }
            }
        }
        res[l][r]=nl;
        return nl;
    }

}