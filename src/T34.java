import java.util.Arrays;

public class T34 {


    public static void main(String[] args) {
        Solution34 s34=new Solution34();
        System.out.println(Arrays.toString(s34.searchRange(new int[]{1,2,3}, 3)));
    }
}
//二分查找中要注意特别考虑left==right的情况。
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int length=nums.length;
        int mid=length/2;
        int left=0;
        int right=length-1;
        int leftSide=-1;
        int rightSide=-1;
//        if(left==right){
//            if(nums[0]==target)return new int[]{0,0};
//            else return new int[]{-1,-1};
//        }
        //寻找左边界nums[mid-1]<nums[mid]=<target mid>1;
        while(left<=right&&left>=0&&right<=length-1){
//            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
//                left=nums[mid+1];
//            }else if(nums[mid]>)
            if(mid==0){
                if(nums[mid]==target){
                    leftSide=mid;
                    break;
                }else{
                    leftSide=-1;
                    break;
                }
            }
            if(left==right){
                if(nums[mid]==target){
                    leftSide=mid;
                }else{
                    break;
                }
            }
            if(nums[mid]>target){
                right=mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                if(nums[mid-1]<target){
                    leftSide=mid;
                    break;
                }else if(nums[mid-1]==target){
                    right=mid;
                }
            }
            mid=(left+right)/2;
            System.out.println(left+" "+right+" "+mid);
        }
        if (leftSide==-1) return new int[]{-1,-1};
        left=0;
        right=length-1;
        mid=(left+right)/2;
        if(nums[length-1]==target){
            rightSide=length-1;
            return new int[]{leftSide,rightSide};
        }
        //寻找右边界
        while(left<=right&&left>=0&&right<=length-1){
//            if(mid==length-1){
//
//            }
            if(left==right){
                if(nums[mid]==target){
                    rightSide=mid;
                }else{
                    break;
                }
            }
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid;
            }else{
                if(target<nums[mid+1]){
                    rightSide=mid;
                    break;
                }else if(target==nums[mid+1]){
                    left=mid+1;
                }
            }
            mid=(left+right)/2;
        }

        return new int[]{leftSide,rightSide};
    }
}