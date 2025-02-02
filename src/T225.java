import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ZhangYihe
 * @since 2025/2/2
 **/
public class T225 {
}
class MyStack {
    Queue<Integer> queue=new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        int num=queue.size();
        queue.offer(x);
        for(int i=0;i<num;i++){
            int n=queue.poll();
            queue.offer(n);
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}