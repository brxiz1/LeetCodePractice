/**
 * @author ZhangYihe
 * @since 2024/10/31
 **/
public class T427 {
}
class Solution427{
    public Node427 construct(int[][] grid) {
        return createNode427Tree(grid,0,grid[0].length-1,0,grid.length-1);
    }
    public Node427 createNode427Tree(int[][] grid,int left,int right,int top,int bottom){
        if(left==right&&top==bottom){
            return new Node427(grid[top][left]==1,true);
        }
        int lm=(left+right)/2;
        int tm=(top+bottom)/2;
        Node427 lt=createNode427Tree(grid,left,lm,top,tm);
        Node427 rt=createNode427Tree(grid,lm+1,right,top,tm);
        Node427 lb=createNode427Tree(grid,left,lm,tm+1,bottom);
        Node427 rb=createNode427Tree(grid,lm+1,right,tm+1,bottom);
        //如果所有子节点都是叶子节点并且值相同，则父节点设为叶子节点
        //反之父节点非叶子节点
        if(lt.isLeaf&&rt.isLeaf&&lb.isLeaf&&rb.isLeaf&&lt.val==rt.val&&rt.val==lb.val&&lb.val==rb.val){
            return new Node427(lt.val,true);
        }else{
            Node427 r=new Node427(false,false);
            r.topLeft=lt;
            r.topRight=rt;
            r.bottomLeft=lb;
            r.bottomRight=rb;
            return r;
        }
    }
}
class Node427 {
    public boolean val;
    public boolean isLeaf;
    public Node427 topLeft;
    public Node427 topRight;
    public Node427 bottomLeft;
    public Node427 bottomRight;


    public Node427() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node427(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node427(boolean val, boolean isLeaf, Node427 topLeft, Node427 topRight, Node427 bottomLeft, Node427 bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}