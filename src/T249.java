import java.util.*;

/**
 * @author ZhangYihe
 * @since 2025/2/3
 **/
public class T249 {
    public static void main(String[] args) {
        Solution249 s249=new Solution249();
        List<List<String>> s=s249.groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z"});
        System.out.println(s);
    }
}
class Solution249{
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strings){
            char[] ch=s.toCharArray();
            int st=ch[0]-'a';
            for(int i=0;i<ch.length;i++){
                ch[i]= (char) (ch[i]-st);
                if(ch[i]<'a')ch[i]+=26;
            }
            String ns=Arrays.toString(ch);
            List<String> nl=map.getOrDefault(ns,new ArrayList<>());
            nl.add(s);
            map.put(ns,nl);
        }
        List<List<String>> resList=new ArrayList<>();
        for(String s:map.keySet()){
            resList.add(map.get(s));
        }
        return resList;
    }
}