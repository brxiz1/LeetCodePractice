/**
 * @author ZhangYihe
 * @since 2025/2/3
 **/
public class T258 {
}
class Solution258{
    public int addDigits(int num) {
        if(num%9!=0){
            return num%9;
        }
        if(num==0)return 0;else return 9;
    }
}