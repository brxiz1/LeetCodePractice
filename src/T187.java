import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangYihe
 * @since 2025/1/27
 **/
public class T187 {

}
class Solution187{
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> countMap=new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String ns=s.substring(i,i+10);
            countMap.put(ns,countMap.getOrDefault(ns,0)+1);
        }
        List<String> res=new ArrayList<>();
        for(String key:countMap.keySet()){
            if(countMap.get(key)>=2)res.add(key);
        }
        return res;
    }
}