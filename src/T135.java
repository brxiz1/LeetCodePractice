import java.util.Arrays;

public class T135 {

}
class Solution135{
    public int candy(int[] ratings) {
        int length=ratings.length;
        int[] left=new int[length];
        left[0]=1;
        for(int i=1;i<length;i++){
            if(ratings[i-1]<ratings[i]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=1;
            }
        }
        int right=left[length-1];
        for(int i=length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                left[i]=Math.max(left[i],right+1);
                right++;
            }else{
                right=1;
            }
        }
        int sum= 0;
        for(int i=0;i<length;i++){
            sum+=left[i];
        }
        return sum;
    }
}
