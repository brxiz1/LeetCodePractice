/**
 * @author ZhangYihe
 * @since 2024/8/23
 **/
public class T222 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        TreeNode l=new TreeNode(1);
        TreeNode r=new TreeNode(2);
        TreeNode l1=new TreeNode(3);
        l.left=l1;
        root.left=l;
        root.right=r;
        Solution222 s222=new Solution222();
        int res= s222.countNodes(root);
        System.out.println(res);

    }
}
//二叉完全树从1开始计数时，如果第 k 个节点位于第 h 层，
// 则 k 的二进制表示包含 h+1 位，其中最高位是 1，
// 其余各位从高到低表示从根节点到第 k 个节点的路径，
// 0 表示移动到左子节点，1 表示移动到右子节点。


class Solution222{
    public int countNodes(TreeNode root) {
        int floors=0;
        TreeNode check=root;
        while (check != null) {
            floors++;
            check=check.left;
        }

        //考虑floor==0和1的边界
        if(floors==0)return 0;
        if(floors==1)return 1;
        int minNum=(int)Math.pow(2,floors-1);
        int maxNum= (int) (Math.pow(2,floors))-1;
        //节点序号从1开始计数
        int left=minNum;
        int right=maxNum;
        int mid=(left+right)/2;
        //最终找到的mid指向了最后一层第一个为空的节点
        //应考虑最后一层没有空节点的可能——没有空节点则left==right同时指向最后一个节点然后退出
        while(left!=right){
            check=root;
            int mid2=(int) (mid - Math.pow(2, floors - 1));
            int floor2=1;
            while(true){

//                if(mid2!=0&&check==null){
//                    right=mid;
//                    break;
//                }else if(mid2==0&&check==null){
//                    left=mid+1;
//                    break;
//                }
                if(floor2==floors){
                    //判断当前是访问到了最后一层还是访问到了最后一层的下一层
                    if(check==null){
                        right=mid;
                    }else{
                        left=mid+1;
                    }
                    break;
                }
                int l=mid2>>(floors-floor2-1);
                if(l==0){
                    check=check.left;
                }else{
                    check=check.right;
                }

                int k0=floors-floor2-1;
                int k=mid2>>(floors-floor2-1)<<(floors-floor2-1);
                mid2=mid2-(mid2>>(floors-floor2-1)<<(floors-floor2-1));
                floor2++;
            }
            mid=(left+right)/2;
        }
        //判断当前mid指向是否是null
        boolean isNull;
        int mid2= (int) (mid - Math.pow(2, floors - 1));
        check=root;
        int floor2=1;
        while(true){
            if(floor2==floors){
                if(check==null){
                    isNull=true;
                }else{
                    isNull=false;
                }
                break;
            }
            int l=mid2>>(floors-floor2-1);
            if(l==0){
                check=check.left;
            }else{
                check=check.right;
            }
            floor2++;
        }
        return isNull?mid-1:mid;
    }
}