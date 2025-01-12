import java.util.Stack;

/**
 * @author ZhangYihe
 * @since 2025/1/10
 **/
public class T099 {


    public static void main(String[] args) {
        Solution99 s99=new Solution99();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(3);
        TreeNode t3=new TreeNode(2);
        t1.left=t2;
        t2.right=t3;
        s99.recoverTree(t1);
    }
}

class Solution99 {
    //morris中序遍历算法（不通过栈实现迭代的中序遍历，空间复杂度为O(1)）,但是不会捏
    //使用栈辅助的迭代中序遍历算法
    public void recoverTree(TreeNode root) {
        TreeNode changePoint1 = null;
        TreeNode changePoint2 = null;
        TreeNode check = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastCheck = null;
        while (!stack.isEmpty()||check!=null) {
            while (check != null) {
                stack.push(check);
                check = check.left;
            }
            check = stack.pop();
            if (lastCheck != null && check.val < lastCheck.val) {
                if (changePoint1 == null) {
                    changePoint1 = lastCheck;
                    changePoint2 = check;
                } else {
                    changePoint2 = check;
                    break;
                }
            }
            lastCheck = check;
            check = check.right;

        }

        int temp = changePoint1.val;
        changePoint1.val = changePoint2.val;
        changePoint2.val = temp;

    }


}