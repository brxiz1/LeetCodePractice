import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/12
 **/
public class T113 {

}

class Solution113{

    List<List<Integer>> lli;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        lli=new ArrayList<>();
        search(root,targetSum,0,new ArrayList<>());
        return lli;
    }

    public void search(TreeNode root,int target,int nowSum,List<Integer> list){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            list.add(root.val);
            if(nowSum+root.val==target)lli.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        search(root.left,target,nowSum+root.val,list);
        search(root.right,target,nowSum+root.val,list);
        list.remove(list.size()-1);

    }

}
