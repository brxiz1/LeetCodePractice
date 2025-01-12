import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/9
 **/
public class T089 {
}

class Solution89{
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<Math.pow(2,n);i++){
            res.add(i^(i>>1));
        }
        return res;
    }
}
