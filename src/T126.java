import java.util.*;

/**
 * @author ZhangYihe
 * @since 2025/1/19
 **/
public class T126 {
}
//todo：没做出来
class Solution126{
    List<List<String>> resList=new ArrayList<>();
    int minLength=Integer.MAX_VALUE;
    public List<List<String>> findLadders(String beginWord,String endWord,List<String> wordList){
        Set<String> wordSet=new HashSet<>(wordList);
        //连通性表
        HashMap<String,List<String>> wordMap=new HashMap<>();
        if(!wordSet.contains(endWord))return new ArrayList<>();

//        wordSet.add(beginWord);
//        for(String word:wordSet){
//            wordMap.put(word,new HashSet<>());
//        }
        //这里删除掉beginword，避免其影响后续判断（会影响吗？）
        wordSet.remove(beginWord);
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        List<String> bl=new ArrayList<>();
        bl.add(beginWord);
        wordMap.put(beginWord,bl);
        //创建联通图
        while(!queue.isEmpty()){
            String s=queue.poll();
            List<String> lastList=wordMap.get(s);
            char[] chs=s.toCharArray();
            for(int i=0;i<chs.length;i++){
                char now=chs[i];
                for(char j='a';j<='z';j++){
                    if(j==now)continue;
                    chs[i]=j;
                    String ns= Arrays.toString(chs);
                    if(wordSet.contains(ns)){
                        wordMap.get(s).add(ns);
                    }
                    chs[i]=now;
                }
            }
        }
        return null;

    }

//    public void search(List<String> list,Queue<String> queue,HashMap<String,Set<String>> map,String endWord){
//        if(queue.isEmpty())return;
//        String s=queue.poll();
//        for(String next:map.get(s)){
//            list.add(next);
//            //防止产生回路
//            map.get(next).remove(s);
//            //已经用过，直接删掉减小规模
//            map.get(s).remove(next);
//            queue.add(next);
//
//        }
//    }



}

class Node126{
    String val;
    Set<String> nodes;
}