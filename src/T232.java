import java.util.Stack;

/**
 * @author ZhangYihe
 * @since 2025/2/3
 **/
public class T232 {
}

class MyQueue {
    Stack<Integer> inputStack=new Stack<>();
    Stack<Integer> outputStack=new Stack<>();
    public MyQueue() {

    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        if(outputStack.isEmpty()){
            while(!inputStack.isEmpty()){
                outputStack.push(inputStack.pop());
            }

        }
        return outputStack.pop();
    }

    public int peek() {
        if(outputStack.isEmpty()){
            while(!inputStack.isEmpty()){
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.empty()&& outputStack.empty();
    }
}