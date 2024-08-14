import java.util.Arrays;

public class T057 {
    public static void main(String[] args) {
        Solution57 s57=new Solution57();
        int[][] res=s57.insert(new int[][]{{0, 1}, {5, 5}, {6, 7}, {9, 11}},new int[]{12,21});
        System.out.println(Arrays.deepToString(res));
    }
}
class Solution57{
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int startIndex=0;
        int endIndex=0;
        boolean isBlank0;
        boolean isBlank1;
        //假定intervals中不包含重合区间
        //找到newInterval[0]在哪个区间
        //newInterval[0]既可能落在一个区间内部，也可能落在两个区间之间
        if(intervals.length==0)return new int[][]{newInterval};
        int left=0;
        int right=intervals.length-1;
        if(left==right){
            if(intervals[0][0]>newInterval[1]){
                return new int[][]{newInterval,intervals[0]};
            }else if(intervals[0][1]<newInterval[0]){
                return new int[][]{intervals[0],newInterval};
            }else{
                return new int[][]{new int[]{Math.min(intervals[0][0],newInterval[0]),Math.max(intervals[0][1],newInterval[1])}};
            }
        }
        int mid=(left+right)/2;
        while(left<right){
            //找到合适区间
            if(intervals[mid][0]<=newInterval[0]&&intervals[mid+1][0]>=newInterval[0]){

                if(intervals[mid][1]>=newInterval[0]){
                    startIndex=mid;
                    isBlank0=false;
                    break;
                }else{
                    isBlank0=true;
                    startIndex=mid+1;
                    break;
                }
            //两种都可能导致left==right
            }else if(intervals[mid][0]>newInterval[0]){

                right=mid;
                //在此left==right：mid对应区间位于new之后，new的0坐标位于全区间左侧?
                if(left==right){
                    if(mid-1<0||intervals[mid-1][1]<=newInterval[0]){
                        isBlank0=true;
                        startIndex=mid-1;
                        break;
                    }else{
                        isBlank0=false;
                        startIndex=mid;
                        break;
                    }
                }
            }else if(intervals[mid +1][0]<newInterval[0]){
                left=mid+1;
                //在此left==right，new的0坐标位于全区间的0坐标右侧?
                if(left==right){
                    if(intervals[mid+1][1]>=newInterval[0]){
                        isBlank0=false;
                        startIndex=mid+1;
                        break;
                    }else{
                        isBlank0=true;
                        startIndex=mid+2;
                        break;
                    }
                }
            }

            mid=(left+right)/2;
        }
        //找到newInterval[1]在哪个区间

        left=0;
        right=intervals.length-1;
        mid=(left+right)/2;
        while(left<right){
            if(intervals[mid][1]<=newInterval[1]&&intervals[mid+1][1]>=newInterval[1]){
                if(intervals[mid+1][0]>newInterval[1]){
                    isBlank1=true;
                    endIndex=mid;
                    break;
                }else{
                    isBlank1=false;
                    endIndex=mid+1;
                    break;
                }
                //两种都可能导致left==right
            }else if(intervals[mid][1]>newInterval[1]){

                right=mid;
                //在此left==right：mid对应区间位于new之后，new的0坐标位于全区间左侧?
                if(left==right){
                    if(intervals[mid][0]<=newInterval[1]){
                        isBlank1=false;
                        endIndex=mid;
                        break;
                    }else{
                        isBlank1=true;
                        endIndex=mid-1;
                        break;
                    }

                }
            }else if(intervals[mid+1][1]<newInterval[1]){
                left=mid+1;
                //在此left==right，new的0坐标位于全区间的0坐标右侧?
                if(left==right){
                    if(mid+2>=intervals.length||intervals[mid+2][0]>=newInterval[1]){
                        isBlank1=true;
                        endIndex=mid+2;
                        break;
                    }else{
                        isBlank1=false;
                        endIndex=mid+1;
                        break;
                    }
                }
            }

            mid=(left+right)/2;
        }
        //获得了startIndex和endIndex
        if(endIndex+1<startIndex){
            System.out.println("error");
            return intervals;
        }

        //这里没有考虑到新区间插入到区间两段或中间，且不与其它区间融合的情况
        //不与其它区间融合的情况：位于头部或尾部startindex=endindex=-1||length,位于中间startindex=endindex+1

        int[][] res=null;
        int midIndex=0;
        if(startIndex==endIndex&&startIndex==-1){

            res=new int[intervals.length+1][2];
            res[0]=newInterval;
            for(int i=1;i<intervals.length+1;i++){
                res[i]=intervals[i-1];
            }
        }else if(startIndex==endIndex&&startIndex==intervals.length){
            res=new int[intervals.length+1][2];
            res[intervals.length]=newInterval;
            for(int i=0;i<intervals.length;i++){
                res[i]=intervals[i];
            }
        }else if(startIndex-endIndex==1){
            res=new int[intervals.length+1][2];
            res[startIndex]=newInterval;
            for(int i=0;i<startIndex;i++){
                res[i]=intervals[i];
            }
            for(int i=startIndex+1;i<intervals.length+1;i++){
                res[i]=intervals[i-1];
            }
        }else{
            int dlen=endIndex-startIndex;
            if(endIndex==intervals.length)dlen--;
            if(startIndex==-1)dlen--;
            res=new int[intervals.length-dlen][2];
            startIndex=Math.max(0,startIndex);
            endIndex=Math.min(intervals.length-1,endIndex);
            int index0=Math.min(intervals[startIndex][0],newInterval[0]);
            int index1=Math.max(intervals[endIndex][1],newInterval[1]);
            for(int i=0;i<intervals.length-dlen;i++){
                if(i==startIndex){
                    res[i][0]=index0;
                    res[i][1]=index1;
                }else if(i<startIndex){
                    res[i][0]=intervals[i][0];
                    res[i][1]=intervals[i][1];
                }else{
                    res[i][0]=intervals[i+dlen][0];
                    res[i][1]=intervals[i+dlen][1];
                }
            }
        }
        return res;
    }
}