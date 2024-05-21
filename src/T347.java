import java.util.HashMap;
import java.util.Map;

public class T347 {
}
class Solution347 {
    Heap root;

    public int[] topKFrequent(int[] nums, int k) {
        root = new Heap(k);
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        for(int key:map.keySet()){
            if(root.addToheap(key,map.get(key))==-1){
                if(root.val[0][1]<map.get(key)) {
                    root.changeHead(key, map.get(key));
                }
            }
        }
        int[] res=new int[k];
        int i=0;
        for(int[] val:root.val){
            res[i++]=val[0];
        }
        return res;

    }


    class Heap{
       int[][] val;
       int nowSize;

       Heap(int size){
           val=new int[size][2];
       }
       int parent(int index){
           return (index-1)/2;
       }
       int leftChild(int index){
           return index*2+1;
       }
       int rightChild(int index){
           return index*2+2;
       }
       void swap(int index1,int index2){
           int temp=val[index1][0];
           val[index1][0]=val[index2][0];
           val[index2][0]=temp;
           temp=val[index1][1];
           val[index1][1]=val[index2][1];
           val[index2][1]=temp;
       }
       void heapifyUp(int index){
           int parent=parent(index);
           if(parent!=index){
               if(val[index][1]<val[parent][1]){
                   swap(parent,index);
                   heapifyUp(parent);
               }
           }
       }
       int addToheap(int num,int freq){
           if(nowSize<val.length){
               val[nowSize][0]=num;
               val[nowSize][1]=freq;
               heapifyUp(nowSize);
               nowSize++;
               return nowSize-1;
           }
           return -1;
       }
       void heapifyDown(int index){
           int minIndex=index;
           int left=leftChild(index);
           int right=rightChild(index);
           if(left+1<=nowSize&&val[minIndex][1]>val[left][1]){
               minIndex=left;
           }
           if(right+1<=nowSize&&val[minIndex][1]>val[right][1]){
               minIndex=right;
           }
           if(minIndex!=index){
               swap(index,minIndex);
               heapifyDown(minIndex);
           }
       }
       void changeHead(int num,int freq){
           val[0][0]=num;
           val[0][1]=freq;
           heapifyDown(0);
       }
    }
}