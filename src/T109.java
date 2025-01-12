/**
 * @author ZhangYihe
 * @since 2025/1/12
 **/
public class T109 {
}

class Solution109{
    ListNode check;
    public TreeNode sortedListToBST(ListNode head) {
        int length=lengthOfListNode(head);
        check=head;
        return treeCreate(0,length-1);
    }

    public int lengthOfListNode(ListNode head){
        ListNode root=head;
        int res=0;
        while(root!=null){
            res++;
            root=root.next;
        }
        return res;
    }

    public TreeNode treeCreate(int left,int right){
        if(left>right)return null;
        if(left==right){
            TreeNode root=new TreeNode(check.val);
            check=check.next;
            return root;

        }
        int mid=(left+right)/2;
        TreeNode leftTree=treeCreate(left,mid-1);
        TreeNode root=new TreeNode(check.val);
        check=check.next;
        TreeNode rightTree=treeCreate(mid+1,right);
        root.left=leftTree;
        root.right=rightTree;
        return root;
    }
}