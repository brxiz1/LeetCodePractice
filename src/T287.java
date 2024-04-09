public class T287 {

}
class Solution287{
    //二分查找的思想****
    public int findDuplicate(int[] nums) {
        int length=nums.length;
        int left=1;
        int right=length;//5
        //left和right实际代表了一个1，2，3...的等差数列的左右端
        //通过对这样一个构造的等差数列做二分查找，不断切掉不符合条件的一半，最终找到答案。
        while(left<right){

            int mid=(left+right)/2;//3,1
            int lessnum=0;
            for(int i:nums){
                if(i<=mid){
                    lessnum++;
                }//5,0
            }
            if(mid<lessnum){
                right=mid;//2
            }else{
                left=mid+1;//2
            }
        }
        return left;
    }
    //通过环路寻址的思路，将数组看作由下标指向值的一串链表，以寻找重复的值（即环路的开始处）
    public int findDuplicate2(int[] nums){
        int slow=0;
        int quick=0;
        while(true){
            slow=nums[slow];
            quick=nums[quick];
            quick=nums[quick];
            if(slow==quick){
                break;
            }
        }
        slow=0;
        while(true){
            slow=nums[slow];
            quick=nums[quick];
            if(slow==quick){
                break;
            }
        }
        return slow;
    }
}