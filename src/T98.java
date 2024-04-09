import javax.swing.tree.TreeNode;

public class T98 {

}



class TreeNode98 {
    int val;
    TreeNode98 left;
     TreeNode98 right;
    TreeNode98() {}
    TreeNode98(int val) { this.val = val; }
     TreeNode98(int val, TreeNode98 left, TreeNode98 right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution98 {
    public boolean isValidBST(TreeNode98 root) {
        return isBinarySearchTree(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isBinarySearchTree(TreeNode98 root,long less,long bigger){
        if(root==null)return true;
//        if(root.val==Integer.MIN_VALUE||root.val==Integer.MAX_VALUE){
//            return root.val==less||root.val==bigger;
//        }
        if(root.val>less &&root.val<bigger){
            if(isBinarySearchTree(root.left,less,root.val)&&isBinarySearchTree(root.right,root.val,bigger)){
                return true;
            }else return false;
        }else{
            return false;
        }
    }
}