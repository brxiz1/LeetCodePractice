import java.util.Stack;

/**
 * @author ZhangYihe
 * @since 2024/8/23
 **/
public class T173 {
}
class BSTIterator {

    Stack<TreeNode> stack;
    int index;
    public BSTIterator(TreeNode root) {
        index=-1;
        stack=new Stack<>();
        TreeNode check=root;
        while(check!=null){
            stack.push(check);
            check=check.left;
        }

    }

    public int next() {
        TreeNode res=stack.pop();
        if(res.right!=null){
            TreeNode check=res.right;
            while(check!=null){
                stack.push(check);
                check=check.left;
            }
        }
        return res.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}