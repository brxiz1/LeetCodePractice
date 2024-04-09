public class T136 {
}
//通过位运算符完成算法
class Solution136 {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i :nums){
            res^=i;
        }
        return res;
    }
}