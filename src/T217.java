import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ZhangYihe
 * @since 2025/2/1
 **/
public class T217 {

}
class Solution217{

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> map=new HashSet<>();
        for(int n:nums){
            if(map.contains(n))return true;
            map.add(n);
        }
        return false;
    }

}