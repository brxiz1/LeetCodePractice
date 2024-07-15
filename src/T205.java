import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T205 {

}
class Solution205{
    public boolean isIsomorphic(String s, String t) {
        int lengths=s.length();
        int lengtht=t.length();
        if(lengths!=lengtht)return false;
        Map<Character,Character> map=new HashMap<>();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<lengths;i++){
            Character chs=s.charAt(i);
            Character cht=t.charAt(i);
            if(map.containsKey(chs)){
                if(cht!=map.get(chs)){
                    return false;
                }
            }else{
                if(set.contains(cht)){
                    return false;
                }else{
                    map.put(chs,cht);
                    set.add(cht);
                }
            }
        }
        return true;
    }
}