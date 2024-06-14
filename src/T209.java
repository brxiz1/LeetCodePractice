public class T209 {
    public static void main(String[] args) {
        Solution209 s209=new Solution209();
        int res=s209.minSubArrayLen1(7,new int[]{2,3,1,2,4,3});
        System.out.println(res);
    }
}
class Solution209{
    public int minSubArrayLen(int target, int[] nums) {
        int length=nums.length;
        int[] frontSum=new int[length];
        frontSum[0]=nums[0];
        for(int i=1;i<length;i++){
            frontSum[i]=frontSum[i-1]+nums[i];
        }
        int minLength=Integer.MAX_VALUE;
        for(int i=length-1;i>=0;i--){
            if(frontSum[i]<target)break;
            int j=quickSearch(frontSum,frontSum[i]-target);
            if(j==-1)minLength=Math.min(minLength,i+1);
            else if(frontSum[j]>frontSum[i]-target)minLength=Math.min(minLength,i-j+1);
            else minLength=Math.min(minLength,i-j);
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }

    public int quickSearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        int length=right+1;
        if(target<arr[left]||target>arr[right])return -1;
        while(left<right){
            int mid=(left+right)/2;
            if(arr[mid]>target){
                right=mid;//注意这里right和left迭代方法的不同
            }else if(arr[mid]<target){
                left=mid+1;
            }else{
                break;
            }
        }
        //在这里找到的其实是第一个大于等于目标的索引
//        if(target!=arr[(left+right)/2])return -1;
        return (left+right)/2;
    }
    public int minSubArrayLen1(int target, int[] nums){
        int length=nums.length;
        int left=0;
        int right=0;
        int nowSum=nums[0];
        int minLength=Integer.MAX_VALUE;
        while(left<length){
            if(nowSum>target){
                minLength=Math.min(minLength,right-left+1);
                left++;
                nowSum-=nums[left-1];
            }else if(nowSum<target){
                right++;
                if(right>=length)break;
                nowSum+=nums[right];
            }else{
                minLength=Math.min(minLength,right-left+1);
                left++;
                nowSum-=nums[left-1];
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }

}