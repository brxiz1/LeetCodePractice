import java.util.*;

/**
 * @author ZhangYihe
 * @since 2024/12/26
 **/
public class T373 {
    public static void main(String[] args) {
        Solution373 s373=new Solution373();
        int[] nums1=new int[]{1,7,11};
        int[] nums2=new int[]{2,4,6};
        List<List<Integer>> res=s373.kSmallestPairs(nums1,nums2,3);
        System.out.println(res);

    }
}

class Solution373{
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue=new PriorityQueue<>(k,
                (i1, i2)->(
                        nums1[i1.get(0)]+nums2[i1.get(1)]-nums1[i2.get(0)]-nums2[i2.get(1)]
                )
        );
        List<List<Integer>> lli=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();
        queue.offer(List.of(0,0));

        for(int i=0;i<k;i++){
            List<Integer> list=queue.poll();
            lli.add(List.of(nums1[list.get(0)],nums2[list.get(1)]));

            if(list.get(1)+1<nums2.length&&!set.contains(List.of(list.get(0),list.get(1)+1))){
                queue.offer(List.of(list.get(0),list.get(1)+1));
                set.add(List.of(list.get(0),list.get(1)+1));
            }
            if(list.get(0)+1<nums1.length&&!set.contains(List.of(list.get(0)+1,list.get(1)))){
                queue.offer(List.of(list.get(0)+1,list.get(1)));
                set.add(List.of(list.get(0)+1,list.get(1)));
            }
        }
        return lli;
    }
}