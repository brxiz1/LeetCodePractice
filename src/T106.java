import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYihe
 * @since 2024/8/21
 **/
public class T106 {
}
class Solution106{
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length=postorder.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<length;i++){
            map.put(inorder[i],i);
        }
        TreeNode res=new TreeNode();
        build(inorder,postorder,res,0,length-1,length-1,map);
        return res;
    }
    public int build(int[] inorder,int[] postorder,TreeNode root,int leftSide,int rightSide,int indexInPost,Map<Integer,Integer> map){
        if(indexInPost<0)return -1;
        int index=map.get(postorder[indexInPost]);
        //index<leftSide:当前节点实际上在父节点左侧
        //index>rightSide似乎不可能？因为右侧且大于Side的一定是更高的节点，但一定已经在postorder中被访问了
        if(index<leftSide){
            //通知上级节点index处非右子节点
            return index;
        }else if(index>rightSide){
            System.out.println("error");
        }

        root.val=postorder[indexInPost];
        int nextIndexInPost=indexInPost-1;
        if(index+1>rightSide){
            root.right=null;
        }else{
            root.right=new TreeNode();
            //indexInPost-1处未必是右子节点
            //如何处理使得nextIndexInPost能反应已经处理的节点数？
            nextIndexInPost=build(inorder,postorder,root.right,index+1,rightSide,nextIndexInPost,map);
            if(nextIndexInPost==indexInPost-1)root.right=null;
            if(nextIndexInPost==-1)return -1;
//            else{
//
//            }
        }

        if(index-1<leftSide){
            root.left=null;
        }else{
            root.left=new TreeNode();
            //nextIndexInPost处一定是左子节点吗？
            //有可能是左子节点的右子树
            nextIndexInPost=build(inorder,postorder,root.left,leftSide,index-1,nextIndexInPost,map);
        }
        //这里应该返回下一个待处理的节点
        return nextIndexInPost;
    }
}