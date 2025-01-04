import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/3
 **/
public class T040 {
}
class Solution040{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        search(res,list,candidates,0,target);
        return res;
    }
    public void search(List<List<Integer>> lli,List<Integer> list,int[] candidates,int index,int nowTarget){
        int lastNum=0;
        for(int i=index;i< candidates.length;i++){
            //跳过重复数字
            if(candidates[i]==lastNum){
                continue;
            }else{
                lastNum=candidates[i];
            }
            if(candidates[i]==nowTarget){
                list.add(nowTarget);
                lli.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                return;
            }else if(candidates[i]>nowTarget){
                return;
            }else{
                list.add(candidates[i]);
                search(lli,list,candidates,i+1,nowTarget-candidates[i]);
                list.remove(list.size()-1);
            }
        }
    }
}