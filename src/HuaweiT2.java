import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HuaweiT2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums=sc.nextInt();
        int[] sorted=new int[nums];
        Set<Integer> set=new HashSet<>();
        int length=0;
        for(int i=0;i<nums;i++){
            int j=sc.nextInt();
            if(set.contains(j)){
                continue;
            }
            set.add(j);
            sorted[length++]=j;
        }
        quickSort(sorted,0,length-1);
        for(int i=0;i<length;i++){
            System.out.println(sorted[i]);
        }
    }
//    public static void quickSort(int[] n, int left, int right){
//        if(left>=right)return;
//        int mid=left+(right-left+1)/2;
//        int r=right;
//        for(int l=left;l<=mid;l++){
//            if(n[l]<=n[mid]){
//                l++;
//                continue;
//            }
//            for(;r>mid;r--){
//                if(n[r]>n[mid]){
//                    break;
//                }
//            }
//            int temp=n[r];
//            n[r]=n[l];
//            n[l]=temp;
//        }
//        for(int i:n){
//            System.out.println("i:"+i);
//        }
//        quickSort(n,left,mid-1);
//        quickSort(n,mid+1,right);
//    }
    public static void quickSort(int[] n,int left,int right){
        if(left<right){
            int pivotIndex=partition(n,left,right);
            quickSort(n,left,pivotIndex-1);
            quickSort(n,pivotIndex+1,right);
        }
    }
    public static int partition(int[] n,int left,int right){
        if(left<right){
            int pivotIndex=right;
            int l=left-1;
            for(int i=left;i<right;i++){
                if(n[i]<n[pivotIndex]){
                    l++;
                    swap(n,l,i);
                }
            }
            swap(n,l+1,pivotIndex);
            return l+1;
        }
        return -1;
    }
    public static void swap(int[] n,int x,int y){
        int temp=n[x];
        n[x]=n[y];
        n[y]=temp;
    }
}
