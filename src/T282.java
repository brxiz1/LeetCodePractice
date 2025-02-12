import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/2/12
 **/
public class T282 {

}

class Solution282{
    int target;
    String num;
    List<String> resList;
    long[][] nums;
    public List<String> addOperators(String num, int target) {
        nums=new long[num.length()][num.length()];
        this.target=target;
        this.num=num;
        resList=new ArrayList<>();
        searchAndCreate(new StringBuilder(),0,0,0);
        return resList;
    }

    public void searchAndCreate(StringBuilder sb,long res,long multiply,int index){
        if(index==num.length()){
            if(res==target){
                resList.add(sb.toString());
            }
            return;
        }
        int nowLength=sb.length();
        for(int i=index;i<num.length();i++){

            long nextNum=getNextNum(index,i);
            if(nextNum==-1)break;//index处有前缀0
            if(index==0){
                sb.append(nextNum);
                searchAndCreate(sb,nextNum,nextNum,i+1);
                sb.delete(nowLength,sb.length());
                continue;
            }
            //+
            sb.append("+").append(nextNum);
            searchAndCreate(sb,res+nextNum,nextNum,i+1);
            sb.delete(nowLength,sb.length());
            //-
            sb.append("-").append(nextNum);
            searchAndCreate(sb,res-nextNum,-nextNum,i+1);
            sb.delete(nowLength,sb.length());
            //*
            sb.append("*").append(nextNum);
            searchAndCreate(sb,res-multiply+multiply*nextNum,multiply*nextNum,i+1);
            sb.delete(nowLength,sb.length());
        }
    }

    public long getNextNum(int l,int r){
        if(l<r&&num.charAt(l)=='0')return -1;
        if(nums[l][r]!=0){
            return nums[l][r];
        }
        long res=0;
        for(int i=l;i<=r;i++){
            res=res*10+ num.charAt(i)-'0';
        }
        nums[l][r]=res;
        return res;
    }
}