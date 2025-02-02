import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author ZhangYihe
 * @since 2025/2/2
 **/
public class T220 {
}

class Solution220{
    //通过TreeSet（红黑树）模拟滑动窗口，快速搜索给定范围内是否存在满足大小要求的值
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int length=nums.length;
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<length;i++){
            //1.查找红黑树中是否存在满足要求的值
            //2.移动滑动窗口，将本节点插入红黑树，从红黑树中取出离开滑动窗口的节点
            Integer n=set.ceiling(nums[i]-valueDiff);
            if(n==null||n>nums[i]+valueDiff){
                set.add(nums[i]);
                if(i-indexDiff>=0){
                    set.remove(nums[i-indexDiff]);
                }
            }else if(n<=nums[i]+valueDiff){
                return true;
            }
        }
        return false;
    }

    //通过桶算法，求一系列元素中是否存在满足大小要求的值
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int indexDiff, int valueDiff) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            //这里要注意nums[i]可能是负数，这里需要平移以避免0两侧的数被划分到同一桶内

            int p=nums[i]>=0?nums[i]/(valueDiff+1):nums[i]/(valueDiff+1)-1;
            if(map.containsKey(p)){
                return true;
            }
            Integer ppn=map.get(p-1);
            Integer pnn=map.get(p+1);
            if(ppn!=null&&nums[i]-ppn<=valueDiff||pnn!=null&&pnn-nums[i]<=valueDiff){
                return true;
            }
            map.put(p,nums[i]);
            if(i>=indexDiff){
                map.remove(nums[i-indexDiff]>=0?nums[i-indexDiff]/(valueDiff+1):nums[i-indexDiff]/(valueDiff+1)-1);
            }
        }
        return false;
    }

}