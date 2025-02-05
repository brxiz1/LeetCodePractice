/**
 * @author ZhangYihe
 * @since 2025/2/4
 **/
public class T260 {
}
class Solution260{
    //两个相同数的按位异或结果为0
    public int[] singleNumber(int[] nums) {
        int n=0;
        for(int i=0;i<nums.length;i++){
            n^=nums[i];
        }
        int m=n==Integer.MIN_VALUE?n:n&(-n);//获取数字n中的最后一个1,注意防止-n溢出
        int x=0,y=0;
        for(int i=0;i< nums.length;i++){
            //注意数字n的最后一个0可能在符号位上
            if ((nums[i] & m )== 0) {
                x^=nums[i];
            }else{
                y^=nums[i];
            }
        }
        return new int[]{x,y};
    }
}