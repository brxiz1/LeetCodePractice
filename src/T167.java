public class T167 {
}
class Solution167{
    public int[] twoSum(int[] numbers, int target) {
        int length=numbers.length;
        int l=0;
        int r=length-1;
        while(l<r){
            if(numbers[l]+numbers[r]<target){
                l++;
            }else if(numbers[l]+numbers[r]>target){
                r--;
            }else{
                return new int[]{l+1,r+1};
            }
        }
        return new int[]{1,1};
    }
}