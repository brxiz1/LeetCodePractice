import java.util.ArrayList;
import java.util.List;

public class T94 {

}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }
}

class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        treeSearch(root,list);
        return list;
    }

    public void treeSearch(TreeNode root,List<Integer> list){
        if(root==null) return;
        treeSearch(root.left,list);
        list.add(root.val);
        treeSearch(root.right,list);
    }
}