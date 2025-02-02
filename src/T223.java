/**
 * @author ZhangYihe
 * @since 2025/2/2
 **/
public class T223 {

}

class Solution223{
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int sq1=(ax2-ax1)*(ay2-ay1);
        int sq2=(bx2-bx1)*(by2-by1);
        int cx1=Math.max(ax1,bx1);
        int cx2=Math.min(ax2,bx2);
        int cy1=Math.max(ay1,by1);
        int cy2=Math.min(ay2,by2);
        int sq3;
        if(cx1>=cx2||cy1>=cy2)sq3=0;
        else sq3=(cx2-cx1)*(cy2-cy1);
        return sq1+sq2-sq3;
    }
}