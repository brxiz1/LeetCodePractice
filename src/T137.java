/**
 * @author ZhangYihe
 * @since 2024/12/27
 **/
public class T137 {
}

class Solution137{
    public int singleNumber(int[] nums) {
        int res=0;
        //依次求每一个二进制位上，nums中所有数之和模3的余数，即为唯一一个单另数字在该二进制位上的数
        for(int i=0;i<32;i++){
            int r=0;
            for(int n:nums){
                r+=(n>>i)&1;
            }
            res+=(r%3)<<i;
        }
        return res;
    }
}