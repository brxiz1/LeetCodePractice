import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ZhangYihe
 * @since 2025/1/27
 **/
public class T179 {
    public static void main(String[] args) {
        Solution179 s179=new Solution179();
        int[] nums=new int[]{10,2};

        String res=s179.largestNumber(nums);
        System.out.println(res);
    }
}

class Solution179{
    public String largestNumber(int[] nums) {
        String[] strNums=new String[nums.length];
        for (int i=0;i< nums.length;i++) {
            strNums[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strNums, (o1, o2) -> {
            String s12=o1+o2;
            String s21=o2+o1;
            return s21.compareTo(s12);//compareTo可以根据字典序比较两个字符串
        });
        StringBuilder sb=new StringBuilder();
        for(String s:strNums){
            sb.append(s);
        }
        //去掉前导0
        for(int i=0;i<sb.length()-1;i++){
            if(sb.charAt(i)=='0'){
                sb.delete(i,i+1);
                i--;
            }else{
                break;
            }
        }
        return sb.toString();
    }
}