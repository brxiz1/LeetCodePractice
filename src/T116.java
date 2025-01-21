/**
 * @author ZhangYihe
 * @since 2025/1/19
 **/
public class T116 {
}

class Solution116{
    public TreeNode116 connect(TreeNode116 root){
        if(root==null||root.left==null)return root;
        root.left.next=root.right;
        if(root.next!=null){
            root.right.next=root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

}

class TreeNode116{
    TreeNode116 left;
    TreeNode116 right;
    TreeNode116 next;
    int val;

}