import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYihe
 * @since 2025/2/5
 **/
public class T266 {
}

class Solution266{
    public boolean canPermutePalindrome(String s) {
        int n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count=0;
        for(char ch:map.keySet()){
            if(map.get(ch)%2!=0){
                count++;
            }
        }
        return count<=1;
    }
}