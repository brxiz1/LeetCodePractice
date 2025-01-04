import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/4
 **/
public class T047 {
    public static void main(String[] args) {
        Solution047 s47=new Solution047();
        List<List<Integer>> lli=s47.permuteUnique(new int[]{1,1,2});
        System.out.println(lli);
    }
}

class Solution047{
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length=nums.length;
        List<List<Integer>> lli=new ArrayList<>();
        Arrays.sort(nums);
        HashSet<Integer> set=new HashSet<>();
        searchAndSet(nums,new ArrayList<>(),lli,set);
        return lli;
    }

    public void searchAndSet(int[] nums,List<Integer> list,List<List<Integer>> lli,HashSet<Integer> set){
        if(list.size()==nums.length){
            lli.add(new ArrayList<>(list));
//            for(Integer i:list){
//                set.remove(i);
//            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0&&!set.contains(i-1)&&nums[i]==nums[i-1]||set.contains(i))continue;
            list.add(nums[i]);
            set.add(i);
            searchAndSet(nums,list,lli,set);
            set.remove(i);
            list.remove(list.size()-1);
        }
    }
}