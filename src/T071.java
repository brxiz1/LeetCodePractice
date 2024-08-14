import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZhangYihe
 * @since 2024/8/14
 **/
public class T071 {
    public static void main(String[] args) {
        Solution71 s71=new Solution71();
        String res=s71.simplifyPath("/home/");
        System.out.println(res);
    }
}
class Solution71{
    public String simplifyPath(String path) {
        Deque<String> deque=new LinkedList<>();
        String[] strs=path.split("/");
        for(int i=0;i< strs.length;i++){
            if(!"".equals(strs[i])){
                if("..".equals(strs[i])){
                    if(!deque.isEmpty()){
                        deque.removeLast();
                    }
                }else if(".".equals(strs[i])){
                    continue;
                }else{
                    deque.addLast(strs[i]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!deque.isEmpty()){
            sb.append("/");
            //deque的getFirst和getlast方法不会导致元素出队列，相当于peek
            sb.append(deque.getFirst());
            deque.removeFirst();
        }
        if(sb.isEmpty())sb.append("/");
        return sb.toString();
    }
}
