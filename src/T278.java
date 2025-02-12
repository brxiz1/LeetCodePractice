/**
 * @author ZhangYihe
 * @since 2025/2/12
 **/
public class T278 {
    public static void main(String[] args) {
        Solution278 s278=new Solution278();
        int res=s278.firstBadVersion(5);
        System.out.println(res);
    }
}

class Solution278 extends VersionControl {
    public int firstBadVersion(int n) {
        int l=1;
        int r=n;
        while(l<r){
            int mid=l+((r-l)>>1);
            if(isBadVersion(mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}
class VersionControl{
    boolean isBadVersion(int v){
        return v>=4;
    }
}