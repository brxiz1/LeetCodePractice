public class T11 {
    public static void main(String[] args) {
        Solution11 s11=new Solution11();
        System.out.println(s11.maxArea(new int[]{1,1}));
    }
}
class Solution11 {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        while(true){
            if(left>=right){
                break;
            }
            if(height[left]>height[right]){
                max=Math.max(max,height[right]*(right-left));
                right--;
            }else{
                max=Math.max(max,height[left]*(right-left));
                left++;
            }
        }
        return max;

    }
}

