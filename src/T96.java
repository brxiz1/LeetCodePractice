public class T96 {
    public static void main(String[] args) {


    }
}
class Solution96 {
    public int numTrees(int n) {
        return createTree(1,n);
    }
    public int createTree(int head,int tail){
        int nums=0;
        if(head>=tail) return 1;
        for(int i=head;i<=tail;i++){
            nums+=createTree(head,i-1)*createTree(i+1,tail);
        }
        return nums;
    }
}