
public class T4 {
    static int[] nums1={1,3,4,9};
    static int[] nums2={2,4,6,8,10};

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    //二分查找
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1=nums1.length;
        int length2=nums2.length;
        int k=(length1+length2)/2;//总长为奇数则k为中位数下标，总长为偶数则k为中位数后一位的下标，从0开始计数


        if((length1+length2)%2==1){
            return findKthElement(nums1,nums2,k+1);//kth代表第kth小的元素的下标，从1开始计数
        }else{
            return (findKthElement(nums1,nums2,k)+findKthElement(nums1,nums2,k+1))/2.0;
        }
    }

    public static double findKthElement(int[] nums1,int[] nums2,int kth){
        int length1=nums1.length;
        int length2=nums2.length;
        int offset1=0;
        int offset2=0;
        int k=kth;
        while(true){
            if(offset1==length1){
                return nums2[offset2+k-1];

            }
            if(offset2==length2){
                return nums1[offset1+k-1];
            }
            if(k==1){
                return Math.min(nums1[offset1],nums2[offset2]);
            }
            int index1=Math.min(length1-1,offset1+k/2-1);
            int index2=Math.min(length2-1,offset2+k/2-1);
            if(nums1[index1]>=nums2[index2]){
                k-=index2+1-offset2;
                offset2=index2+1;
            }else{
                k-=index1+1-offset1;
                offset1=index1+1;
            }


            System.out.println(k);
        }
    }

}