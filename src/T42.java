public class T42 {
    public static void main(String[] args) {
        Solution42 s42=new Solution42();
        System.out.println(s42.trap(new int[]{4,2,0,3,2,5}));
    }
}
class Solution42 {
    //雨水承接量取决于两侧高峰之中的较低者
    //解法1：动态规划
    public int trap(int[] height) {
        int length=height.length;
        int[] left=new int[length];
        int[] right=new int[length];
        for(int i=0;i<length;i++){
            if(i==0){
                left[i]=height[i];
                right[length-i-1]=height[length-i-1];
                continue;
            }
            left[i]=Math.max(left[i-1],height[i]);
            right[length-i-1]=Math.max(right[length-i],height[length-i-1]);
        }
        int sum=0;
        for(int i=0;i<length;i++){
            sum+=Math.max(Math.min(left[i],right[i])-height[i],0);
        }
        return sum;

    }


}