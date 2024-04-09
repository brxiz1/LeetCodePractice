import java.util.HashMap;
import java.util.Map;

public class T105 {

}
//通过前序和中序遍历结果构建二叉树
//使用了确定左右子树构成元素，然后递归构造二叉树的方法。
class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=new TreeNode();
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return createTree(preorder,map,0,preorder.length-1,0,inorder.length-1);

    }
    public TreeNode createTree(int[] preorder,Map<Integer,Integer> map,
                           int leftPre,int rightPre,int leftIn,int rightIn){
        if(leftPre>rightPre){
            return null;
        }
        if(leftPre==rightPre)return new TreeNode(preorder[leftPre]);
        int rootNo=map.get(preorder[leftPre]);
        int lengthLeft=rootNo-leftIn;
        int lengthRight=rightIn-rootNo;
        TreeNode leftTree=createTree(preorder,map,leftPre+1,leftPre+lengthLeft,leftIn,rootNo-1);
        TreeNode rightTree=createTree(preorder,map,leftPre+lengthLeft+1,rightPre,rootNo+1,rightIn);
        return new TreeNode(preorder[leftPre],leftTree,rightTree);
    }


}