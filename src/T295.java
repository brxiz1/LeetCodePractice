import java.util.PriorityQueue;

/**
 * @author ZhangYihe
 * @since 2024/12/27
 **/
public class T295 {
    public static void main(String[] args) {
        MedianFinder mf=new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        double m=mf.findMedian();
        System.out.println(m);
    }

}

class MedianFinder {
    //分别用两个堆维护小等于中位数和大于中位数的数组，以方便快速确定中位数
    PriorityQueue<Integer> minQueue=new PriorityQueue<>((i1,i2)->i2-i1);
    PriorityQueue<Integer> maxQueue=new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if(minQueue.isEmpty()){
            minQueue.offer(num);
            return;
        }
        if(num<=minQueue.peek()){
            minQueue.offer(num);
            if(minQueue.size()>=maxQueue.size()+2){
                int n=minQueue.poll();
                maxQueue.offer(n);
            }
        }else{
            maxQueue.offer(num);
            if(maxQueue.size()>minQueue.size()){
                int n=maxQueue.poll();
                minQueue.offer(n);
            }
        }
    }

    public double findMedian() {
        if(minQueue.size()==maxQueue.size()){
            return (double) (minQueue.peek() + maxQueue.peek()) /2;
        }else{
            return minQueue.peek();
        }
    }

}