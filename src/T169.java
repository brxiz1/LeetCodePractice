public class T169 {

}

class Solution169 {
    public int majorityElement(int[] nums) {
        int vote=0;
        int maxmize=0;
        for(int num:nums){
            if(vote==0){
                maxmize=num;
            }
            if(maxmize==num)vote++;
            else vote--;
        }
        return maxmize;
    }
}