import java.util.*;

/**
 * @author ZhangYihe
 * @since 2025/1/5
 **/
public class T060 {

}

class Solution60{
    public String getPermutation(int n, int k) {
        Set<Integer> usedNum=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        setPermutation(n,k-1,sb,usedNum);
        return sb.toString();
    }

    public void setPermutation(int n,int k,StringBuilder nowNum,Set<Integer> usedNum){
        if(n<=0)return;
        int jc=jieCheng(n-1);
       int index=k/jc;
       int num=0;
       int i=0;
       while(i<=index){
           num++;
           if(!usedNum.contains(num))i++;
       }
       nowNum.append(num);
       usedNum.add(num);
       setPermutation(n-1,k%jc,nowNum,usedNum);
    }

    public int jieCheng(int n){
        int res=1;
        for(int i=1;i<=n;i++){
            res*=i;
        }
        return res;
    }
}