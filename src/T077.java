import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2024/10/25
 **/
public class T077 {
}
class Solution77{
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lli=new ArrayList<>();
//        List<Integer> li=new ArrayList<>();
//        for(int i=1;i<=n;i++){
//            li.add(i);
//            for(int j=i+1;j<=n;j++){
//                li.add(j);
//                for(int s=j+1;s<=n;s++){
//                    li.add(s);
//                    lli.add(new ArrayList<>(li));
//                    li.remove(2);
//                }
//                li.remove(1);
//            }
//            li.remove(0);
//        }
        for(int i=1;i<=n;i++){
            List<Integer> l=new ArrayList<>();
            l.add(i);
            lli.add(l);
        }
        for(int i=0;i<k;i++){
            lli=addNum(lli,n);
        }
        return lli;
    }
    public List<List<Integer>> addNum(List<List<Integer>> lli,int n){
        List<List<Integer>> nlli=new ArrayList<>();
        for(List<Integer> li:lli){
            int m=li.getLast();
            for(int j=m+1;j<=n;j++){
                List<Integer> l=new ArrayList<>(li);
                l.add(j);
                nlli.add(l);
            }
        }
        return nlli;
    }
}
