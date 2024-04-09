import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class T76 {
    public static void main(String[] args) {
        Solution76 s76=new Solution76();
        System.out.println("a".substring(0,0));
        System.out.println(s76.minWindow("ADOBECODEBANC","ABCO"));
    }
}
class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character,Integer> m=new HashMap<>();

        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        for (char c : tt) {
            if (m.containsKey(c)) {
                m.put(c, m.get(c) + 1);
            } else {
                m.put(c, 1);
            }
        }
        int i=0;
        int j=0;
        int[] shortest=new int[]{0, ss.length};
        Map<Character,Integer> mt=new HashMap<>(m);
        boolean isChanged=false;
        boolean isFound=false;
        while(j<ss.length&&i<=j){
            for(;j<ss.length;j++){
                if(isChanged&&isEmpty(mt)){
                    break;
                }
                if(mt.containsKey(ss[j])){
                    mt.put(ss[j],mt.get(ss[j])-1);
                    isChanged=true;
                }

            }
            isChanged=true;
            for(;i<=j;i++){
                if(isChanged&&!isEmpty(mt)){
                    isChanged=false;
                    break;
                }else if(j-i<=shortest[1]-shortest[0]){
                    isFound=true;
                    shortest[0]=i;
                    shortest[1]=j;
                }
                if(mt.containsKey(ss[i])){
                    mt.put(ss[i],mt.get(ss[i])+1);
                    isChanged=true;
                }else{
                    isChanged=false;
                }
            }
        }
        System.out.println(shortest[0]+" "+shortest[1]);
        return isFound?s.substring(shortest[0],shortest[1]):"";
    }
    public boolean isEmpty(Map<Character,Integer> map){
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            Map.Entry entry = (Map.Entry) characterIntegerEntry;
            if ((int) entry.getValue() > 0) return false;
        }
        return true;
    }
}
