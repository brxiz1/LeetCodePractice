import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class T239 {
    public static void main(String[] args) {
        Solution239 s239=new Solution239();
        System.out.println(Arrays.toString(s239.maxSlidingWindow(new int[]{1, -1}, 1)));
    }
}

class Solution239{
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Node239> list=new LinkedList<>();
        int length=nums.length;
        int[] maxInWindow=new int[length-k+1];
//        list.addLast(nums[0]);
        if(length==1) return nums;
        //维护了一个单调递增的双端队列
        for(int i=0;i<k-1;i++){
            while(list.peekLast()!=null&&list.peekLast().val<nums[i]){
                list.removeLast();
            }
            list.addLast(new Node239(nums[i],i));
        }

        for(int i=k-1;i<length;i++){
            while(list.peekLast()!=null&&list.peekLast().val<nums[i]){
                list.removeLast();
            }
            list.addLast(new Node239(nums[i],i));
            while(list.peekFirst().index<i-k+1){
                list.removeFirst();
            }
            maxInWindow[i-k+1]=list.peekFirst().val;
        }
        return maxInWindow;
    }
    class Node239{
        int val;
        int index;
        Node239(int val,int index){
            this.val=val;
            this.index=index;
        }
    }
}