/**
 * @author ZhangYihe
 * @since 2024/12/27
 **/
public class T201 {
}
class Solution201{
    //本质上是在寻找最长公共前缀
    public int rangeBitwiseAnd(int left, int right) {
        int bitCount=0;
        while(left!=right){
            bitCount++;
            left>>=1;
            right>>=1;
        }
        left<<=bitCount;
        return left;
    }
}