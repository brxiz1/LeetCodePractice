import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/9
 **/
public class T090 {
    public static void main(String[] args) {
        Solution90 s90=new Solution90();
        int[] nums=new int[]{1,2,2};
        List<List<Integer>> lli=s90.subsetsWithDup(nums);
        System.out.println(lli);
    }
}

class Solution90{
    int[] nums;
    List<List<Integer>> lli;
    int length;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums=nums;
        lli=new ArrayList<>();
        length=nums.length;
        lli.add(new ArrayList<>());
        search(new ArrayList<>(),0);
        return lli;
    }
    public void search(List<Integer> list,int index){

        for(int i=index;i<length;i++){
            if(i>index&&nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            lli.add(new ArrayList<>(list));
            search(list,i+1);
            list.remove(list.size()-1);
        }
    }

}