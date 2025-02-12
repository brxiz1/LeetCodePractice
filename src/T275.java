/**
 * @author ZhangYihe
 * @since 2025/2/5
 **/
public class T275 {
}

class Solution275{

    public int hIndex(int[] citations) {
        int l=0;
        int r=citations.length-1;
        int length=citations.length;
        if(length==1)return Math.min(1,citations[0]);
        while(l<r-1){
            int mid=(l+r)/2;
            if(citations[mid]>length-mid){
                r=mid;
            }else if(citations[mid]==length-mid){
                return length-mid;
            }else{
                l=mid;
            }
        }
        return Math.max(Math.min(citations[l],length-l),Math.min(citations[r],length-r));
    }
}
