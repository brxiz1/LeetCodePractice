import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T290 {
}
class Solution290{
    public boolean wordPattern(String pattern, String s) {
        int lengthP=pattern.length();
//        int lengthp=p.length();
        String[] strs=s.split(" ");

        if(lengthP!=strs.length)return false;
        Map<Character,String> map=new HashMap<>();
        Set<String> set=new HashSet<>();
        for(int i=0;i<lengthP;i++){
            Character ch=pattern.charAt(i);
//            Character cht=t.charAt(i);
            if(map.containsKey(ch)){
                if(!strs[i].equals(map.get(ch))){
                    return false;
                }
            }else{
                if(set.contains(strs[i])){
                    return false;
                }else{
                    map.put(ch,strs[i]);
                    set.add(strs[i]);
                }
            }
        }
        return true;
    }

}
