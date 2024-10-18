/**
 * @author ZhangYihe
 * @since 2024/10/17
 **/
import java.util.*;

public class T127 {
    public static void main(String[] args) {
        Solution127 s127=new Solution127();
        int res=s127.ladderLength("hit","cog",List.of("hot","dot","dog","lot","log","cog"));
        System.out.println(res);
    }
}
class Solution127{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordLength=beginWord.length();
        if(beginWord.equals(endWord))return 2;
//        Set<String> wordBank=new HashSet<>(wordList);
//        wordBank.add(beginWord);
//        if(!wordBank.contains(endWord))return 0;
        int endIndex=-1;
        for(int i=0;i<wordList.size();i++){
            if(wordList.get(i).equals(endWord)){
                endIndex=i;
                break;
            }
        }
        if(endIndex==-1)return 0;
        //创建联通图
        List<String> words=new ArrayList<>();
        words.add(beginWord);
//        words.add(endWord);
        words.addAll(wordList);
        endIndex++;
        List<List<Integer>> connections=new ArrayList<>();
        //0:beginWord,1 endWord,2--length+1 wordList
        for(int i=0;i<words.size();i++){
            connections.add(new ArrayList<>());
        }
        Map<String,Integer> map=new HashMap<>();//key:中间节点的值，value:中间节点在connections中的index
        //向联通图添加中间节点,添加连接信息
        for(int i=0;i<wordList.size()+1;i++){
            StringBuilder sb=new StringBuilder(words.get(i));
            for(int j=0;j<wordLength;j++){
                char before=sb.charAt(j);
                sb.setCharAt(j,'*');
                String midNode=sb.toString();
                sb.setCharAt(j,before);
                //判断新的midNode是否已经存在
                int index;
                if(map.containsKey(midNode)){
                    index=map.get(midNode);

                }else{
                    index=words.size();
                    map.put(midNode,index);
                    connections.add(new ArrayList<>());
                    words.add(midNode);
                }
                //双向连接
                connections.get(index).add(i);
                connections.get(i).add(index);
            }
        }

        //开始双重广度优先遍历
//        Map<Integer,Integer> fromHead=new HashSet<>();
//        Set<Integer> fromTail=new HashSet<>();
        int[] fromHead=new int[connections.size()];//index与connections对齐，value代表到该节点的步数，从1开始
        int[] fromTail=new int[connections.size()];
        fromHead[0]=1;
        fromTail[endIndex]=1;
        Queue<Integer> headQueue=new LinkedList<>();
        Queue<Integer> tailQueue=new LinkedList<>();
        headQueue.add(0);
        tailQueue.add(endIndex);
        //如何迭代步数？
        while(!headQueue.isEmpty()&&!tailQueue.isEmpty()){
            //从头节点开始的广度优先遍历
            int headIndex=headQueue.poll();
            for(int i:connections.get(headIndex)){
                //当前节点未访问过
                if(fromHead[i]==0){
                    fromHead[i]=fromHead[headIndex]+1;
                    headQueue.offer(i);
                    if(fromTail[i]!=0){
                        return (fromHead[i]+fromTail[i])/2;//fromHead[i]+fromTail[i]是否可能不是2的倍数？不可能
                    }

                }

            }
            //从尾节点开始的广度优先遍历
            int tailIndex=tailQueue.poll();
            for(int i:connections.get(tailIndex)){
                if(fromTail[i]==0){
                    fromTail[i]=fromTail[tailIndex]+1;
                    tailQueue.offer(i);
                    if(fromHead[i]!=0){
                        return (fromHead[i]+fromTail[i])/2;
                    }

                }
            }
        }
        return 0;
    }
}