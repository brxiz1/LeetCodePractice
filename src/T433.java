import java.util.*;

/**
 * @author ZhangYihe
 * @since 2024/10/16
 **/
public class T433 {
}
class Solution433{
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene))return 0;
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if(!bankSet.contains(endGene))return -1;
        List<Character> charList=List.of('A','C','G','T');
        //可能需要改变的不只有startGene与endGene间不同的坐标，要考虑到bank的内容
//        List<Integer> diffIndex=new ArrayList<>();
//
//        for(int i=0;i<8;i++){
//            if(startGene.charAt(i)!=endGene.charAt(i)){
//                diffIndex.add(i);
//            }
//        }
//        int diffNum=diffIndex.size();
        //不关心当前string已经修改了哪些元素，而是保存已经产生过的所有string，只处理新产生的string以避免重复和循环修改
        Set<String> visitedString=new HashSet<>();
//        Queue<HashSet<Integer>> visitedList=new LinkedList<>();//已修改的index
//        visitedList.offer(new HashSet<>());
        Queue<Integer> queue=new LinkedList<>();//当前修改了多少次
        Queue<String> pool=new LinkedList<>();//当前string
        //queue和pool要同步offer和poll
        pool.offer(startGene);
        queue.offer(0);
        //退出条件：第一次修改成功
        while(!queue.isEmpty()){
            int num=queue.poll();
            String s=pool.poll();
            for(int i=0;i<8;i++){
                for(char ch:charList){
                    StringBuilder sb=new StringBuilder(s);
                    sb.setCharAt(i,ch);
                    String s2=sb.toString();
                    if(bankSet.contains(s2)&&!visitedString.contains(s2)){
                        if(s2.equals(endGene)){
                            return num+1;
                        }
                        visitedString.add(s2);
                        pool.offer(s2);
                        queue.offer(num+1);
                    }
                }
            }
        }
        return -1;

    }
}