import java.util.ArrayList;
import java.util.List;

public class T39 {
    public static void main(String[] args) {
        Solution39 s39=new Solution39();
        System.out.println(s39.combinationSum(new int[]{},7));
    }
}
class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lli=new ArrayList<List<Integer>>();

        ArrayList<Integer> list=new ArrayList<>();
//        for(int i:candidates){
//            list.add(i);
//        }
        createList(lli,list,candidates,0,candidates.length,target);
        return lli;
    }
    public void createList(List<List<Integer>> lli,ArrayList<Integer> list,
                           int[] candidates,int index,int length,int target){
        int sum=0;
        for(Integer i:list){
            sum+=i;
        }
        if(sum>target){
            return;
        }else if(sum==target){
            ArrayList<Integer> newList=new ArrayList<>(list);
            lli.add(newList);
            return;
        }
        for(int i=index;i<length;i++){
            list.add(candidates[i]);
            createList(lli,list,candidates,i,length,target);
            list.remove(list.size()-1);
        }
    }
}