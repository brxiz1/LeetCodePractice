public class T461 {

}
class Solution461{
    public int hammingDistance(int x, int y) {
        int z=x^y;
        int res=0;
        while(z>0){
            int i=z&1;
            if(i==1){
                res++;
            }
            z>>=1;
        }
        return res;
    }
}
