import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/19
 **/
public class T118 {
}
class Solution118{
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> lli=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        l.add(1);
        lli.add(l);
        for(int i=1;i<numRows;i++){
            List<Integer> lastList=lli.get(i-1);
            List<Integer> list=new ArrayList<>();
            list.add(1);
            for(int j=1;j<i;j++){
                list.add(lastList.get(j-1)+lastList.get(j));
            }
            list.add(1);
            lli.add(list);
        }
        return lli;
    }
}
