import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/19
 **/
public class T131 {
}

class Solution131{
    int[][] checkRes;
    List<List<String>> resList=new ArrayList<>();
    List<String> list=new ArrayList<>();
    public List<List<String>> partition(String s){

        checkRes=new int[s.length()][s.length()];
        check(s,0);
        return resList;
    }
    public void check(String s,int i){
        if(i==s.length()){
            resList.add(new ArrayList<>(list));
            return;
        }
        for(int j=0;j+i<s.length();j++){
            if(checkRes[i][i+j]==-1)continue;
            if(checkRes[i][i+j]==1||isLoop(s,i,i+j)){
                checkRes[i][i+j]=1;
                list.add(s.substring(i,i+j+1));
                check(s,i+j+1);
                list.remove(list.size()-1);
            }else{
                checkRes[i][i+j]=-1;
            }
        }
    }
    public boolean isLoop(String s,int i,int j){
        if(i==j)return true;
        for(;i<=j;i++,j--){
            if(s.charAt(i)!=s.charAt(j))return false;
        }
        return true;
    }
}