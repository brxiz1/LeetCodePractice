public class T045 {

}
class Solution45{
    //对数组边界的判定依然薄弱
    public int jump(int[] nums) {
        int length=nums.length;
        int[] jump=new int[length];
        int right=1;
        for(int i=0;i<right;i++){
            if(right>=length){
                break;
            }
            int j=right;
            for(;j<=nums[i]+i;j++){
                if(j>=length)break;
                jump[j]=jump[i]+1;
            }
            right=j;
        }
        return jump[length-1];
    }
}
