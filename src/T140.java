import java.util.*;

/**
 * @author ZhangYihe
 * @since 2025/1/20
 **/
public class T140 {
}
//todo:未完成
class Solution140{
    List<String> resList=new ArrayList<>();
    Set<String> wordSet;
    Map<Integer,List<String>> sMap;
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet=new HashSet<>(wordDict);
        sMap=new HashMap<>();
        int length=s.length();
        return null;
    }
    public String search(String s,StringBuilder formS,int index){
        //这里的退出条件正确吗？
        if(index>=s.length()){
            resList.add(formS.toString());
        }
        for(int i=index;i<s.length();i++){
            List<String> buildS=new ArrayList<>();
            if(sMap.containsKey(i)){
                for(String nextS:sMap.get(i)){
                    resList.add(formS+" "+nextS);
                }
            }else{
                String ns=getWord(s,index,i);
                if(ns!=null){
                    if(formS.isEmpty())formS.append(ns);
                    else formS.append(" ").append(ns);
                    String res=search(s,formS,i);
                    buildS.add(res);
                }

            }
        }
        return null;
    }

    public String getWord(String s,int i,int j){

        String ns=s.substring(i,j+1);
        if(wordSet.contains(ns))return ns;
        else return null;
    }
}
