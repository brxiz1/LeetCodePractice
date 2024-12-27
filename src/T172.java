/**
 * @author ZhangYihe
 * @since 2024/12/27
 **/
public class T172 {

}
class Solution172{
    //本质上就是求n!中有多少个5,
    // 故依次求1~n中有多少个5的倍数、25的倍数、125的倍数……
    // 相加后即为结果
    public int trailingZeroes(int n) {
        int res=0;
        while(n>=5){
            n/=5;
            res+=n;
        }
        return res;

    }
}