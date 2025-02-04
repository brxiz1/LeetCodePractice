import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/2/3
 **/
public class T257 {
    public static void main(String[] args) {
        Solution257 solution257=new Solution257();
        TreeNode r1=new TreeNode(1);
        TreeNode r2=new TreeNode(2);
        TreeNode r3=new TreeNode(3);
        r1.left=r2;
        r1.right=r3;
        List<String> res=solution257.binaryTreePaths(r1);
        System.out.println(res);
    }
}
class Solution257{
    List<String> resList=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        sb.append(root.val);
        if(root.left==null&&root.right==null){
            resList.add(sb.toString());
        }
        dps(sb,root.left);
        dps(sb,root.right);
        return resList;
    }
    public void dps(StringBuilder sb,TreeNode root){
        if(root==null){
            return;
        }
        int length=sb.length();
        sb.append("->").append(root.val);
        if(root.left==null&&root.right==null){
            resList.add(sb.toString());
            sb.replace(length,sb.length(),"");
            return;
        }

        dps(sb,root.left);
        dps(sb,root.right);
        sb.replace(length,sb.length(),"");

    }
}