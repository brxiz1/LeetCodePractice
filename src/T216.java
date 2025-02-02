import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/2/1
 **/
public class T216 {
}

class Solution216{
    List<Integer> list=new ArrayList<>();
    List<List<Integer>> resList=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k,n,1,0);
        return resList;
    }

    public void dfs(int k,int n,int nowNum,int nowSum){
        if(list.size()==k&&nowSum==n){
            resList.add(new ArrayList<>(list));
            return;
        }
        while(nowNum<10&&nowSum+nowNum<=n){
            list.add(nowNum);
            dfs(k,n,nowNum+1,nowSum+nowNum);
            nowNum++;
            list.remove(list.size()-1);
        }
    }
}