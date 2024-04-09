import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class T297 {
    public static void main(String[] args) {
        String s="-1,-2,-3,-4,-5,";
        System.out.println(Arrays.toString(s.split(",")));
    }
}
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            TreeNode t=q.poll();
            if(t==null){
                sb.append("n,");
            }else{
                sb.append(t.val).append(",");
                q.offer(t.left);
                q.offer(t.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str=data.split(",");
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode();
        if(str[0].equals("n")){
            return null;
        }
        root.val=Integer.parseInt(str[0]);
        q.offer(root);
        int left=1;
        int right=2;
        int length=str.length;
        while(!q.isEmpty()){

            TreeNode t=q.poll();
            if(t==null) continue;

            if(left>=length){
                break;
            }
            TreeNode lt=null;
            if(!str[left].equals("n")){
                lt=new TreeNode(Integer.parseInt(str[left]));
            }
            q.offer(lt);
            t.left=lt;
            left+=2;

            if(right>=length)break;
            TreeNode rt=null;
            if(!str[right].equals("n")){
                rt=new TreeNode(Integer.parseInt(str[right]));
            }
            q.offer(rt);
            t.right=rt;
            right+=2;
        }
        return root;
    }
}