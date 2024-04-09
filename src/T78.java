import java.util.ArrayList;
import java.util.List;

public class T78 {
    public static void main(String[] args) {
        Solution78 s78=new Solution78();
        System.out.println(s78.subsets(new int[]{1,2,3}));
    }
}
class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lli=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        deepsearch(nums,lli,list,0);
        return lli;
    }
    public void deepsearch(int[] nums,List<List<Integer>> lli,List<Integer> list,
                           int index){
        if(index>nums.length-1){
            lli.add(new ArrayList<>(list));
            return;
        }
        deepsearch(nums,lli,list,index+1);
        list.add(nums[index]);
        deepsearch(nums,lli,list,index+1);
        list.remove(list.size()-1);

    }
}
