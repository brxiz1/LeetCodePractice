import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T139 {

}
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length=s.length();
        boolean[] isExist=new boolean[s.length()+1];
//        for(boolean b:isExist){
//            b=false;
//        }
        Map<String,Integer> map=new HashMap<>();
        for(String word:wordDict){
            map.put(word,0);
        }
        isExist[0]=true;
        for(int i=1;i<length+1;i++){
            for(int j=0;j<i;j++){
                //注意j在isExist[j]和s.substring(j,i)中含义的不同，前者指代长为j的字符串，后者指字符串的j号元素。
                if(isExist[j]&&map.containsKey(s.substring(j,i))){
                    isExist[i]=true;
                    break;
                }
            }
        }
        return isExist[length];
    }
}