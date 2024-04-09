import java.util.*;

public class T49 {
    public static void main(String[] args) {
        Solution49 s49=new Solution49();
        System.out.println(s49.groupAnagrams(new String[]{"a"}));
    }
}
class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lls=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] ctr= str.toCharArray();
            Arrays.sort(ctr);
            String str1=new String(ctr);
            List<String> ls=map.getOrDefault(str1,new ArrayList<>());
            ls.add(str);
            map.put(str1,ls);
        }
        for(String s :map.keySet()){
            lls.add(map.get(s));
        }
        return lls;
    }
}
