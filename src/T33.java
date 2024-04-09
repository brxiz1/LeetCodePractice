public class T33 {

    public static void main(String[] args) {
        Solution33 s33=new Solution33();
        System.out.println(s33.search(new int[]{1,3},3));
    }
}
class Solution33 {
    public int search(int[] nums, int target) {
        if(nums.length==0)return -1;
        if(target<nums[0]&&target>nums[nums.length-1]) return -1;
//        if(target>nums[0]){
//            int mid=nums.length/2;
//            int left=0;
//            int right=nums.length-1;
//            int lastmid=mid;
//            while(true){
//                if(nums[mid]>nums[0]){
//                    if(nums[mid]>target){
//                        right=mid;
//                    }else if(nums[mid]<target){
//                        left=mid;
//                    }else{
//                        return mid;
//                    }
//                }else{
////                    if(nums[mid]<target){
////                        mid=(nums.length-mid)/2;
////                    }else if(nums[mid]>target){
////                        mid=mid/2;
////                    }else{
////                        return mid;
////                    }
//                    right=mid;
//                }
//                if(right==left)break;
//                if(mid==(left+right)/2){
//                    break;
//                }else{
//                    mid=(left+right)/2;
//                }
//            }
//        }else if(target<nums[0]){
//            int mid=nums.length/2;
//            int left=0;
//            int right=nums.length-1;
//            if(nums[right]==target) return right;
//            while(true){
//                if(nums[mid]>nums[0]){
//                    left=mid;
//                }else{
//                    if(nums[mid]<target){
//                        left=mid;
//                    }else if(nums[mid]>target){
//                        right=mid;
//                    }else{
//                        return mid;
//                    }
//                }
//                if(right==left)break;
//                if(mid==(left+right)/2){
//                    break;
//                }else{
//                    mid=(left+right)/2;
//                }
//            }
//        }else{
//            return 0;
//        }
//        return -1;
//    }
        int left=0;
        int right=nums.length-1;
        int mid=(left+right)/2;
        while(left<=right){
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[0]){//nums[mid]==nums[0]时,它也在左段的有序列中，要考虑进去。
                if(target>=nums[0]&&nums[mid]>target){//target>=nums[0]照顾边际条件
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(target<=nums[nums.length-1]&&target>nums[mid]){//target<=nums[length-1]照顾边际条件
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            mid=(left+right)/2;
        }
        return -1;
    }
}
