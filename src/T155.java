import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

public class T155 {
}

class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> min;

    public MinStack() {
        s=new Stack<>();
        min=new Stack<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        s.push(val);
        min.push(Math.min(min.peek(),val));
    }

    public void pop() {
        s.pop();
        min.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}