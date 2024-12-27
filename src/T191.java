/**
 * @author ZhangYihe
 * @since 2024/12/27
 **/
public class T191 {

}
class Solution191{
    public int hammingWeight(int n) {
        int res=0;
        //n&(2^i),快速判断n的二进制第i位是否为1
        for(int i=0;i<32;i++){
            res+=(n&(1<<i))>0?1:0;
        }
        return res;
    }
}