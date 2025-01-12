import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/9
 **/
public class T095 {
    public static void main(String[] args) {
        Solution95 s95=new Solution95();
        List<TreeNode> res=s95.generateTrees(3);
        System.out.println(res);
    }
}

class Solution95{
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res=generate(1,n);
        return res;
    }
    public List<TreeNode> generate(int l,int r){
        if(l>r){
            List<TreeNode> res=new ArrayList<>();
            res.add(null);
            return res;
        }
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right=new ArrayList<>();
        List<TreeNode> res=new ArrayList<>();

        for(int i=l;i<=r;i++){
            left=generate(l,i-1);
            right=generate(i+1,r);


                for(TreeNode lt:left){
                    for(TreeNode rt:right){
                        TreeNode root=new TreeNode(i);
                        root.left=lt;
                        root.right=rt;
                        res.add(root);
                    }
                }

        }


        return res;
    }
}