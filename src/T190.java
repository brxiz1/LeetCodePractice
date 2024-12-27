/**
 * @author ZhangYihe
 * @since 2024/12/27
 **/
public class T190 {
}

class Solution190{
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            //通过n&1可以直接取到n的第0位数字，通过&取二进制的某一位数字是常用方法
            res|=(n&1)<<(31-i);
            n>>>=1;
        }
        return res;
    }
}