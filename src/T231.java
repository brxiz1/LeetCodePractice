/**
 * @author ZhangYihe
 * @since 2025/2/3
 **/
public class T231 {
}

class Solution231{
    public boolean isPowerOfTwo(int n) {
        //n&(n-1)---将正数n的最后一位1取反
        return n>0&&(n&(n-1))==0;
    }
}