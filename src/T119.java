import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/19
 **/
public class T119 {
    public static void main(String[] args) {
        Solution119 solution119=new Solution119();
        List<Integer> list=solution119.getRow(3);
        System.out.println(list);
    }
}
class Solution119{
    public List<Integer> getRow(int rowIndex){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        for(int i=1;i<=rowIndex;i++){

            for(int j=i-1;j>0;j--){
                list.set(j,list.get(j-1)+list.get(j));
            }
            list.add(1);
        }
        return list;
    }


}