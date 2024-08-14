import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T228 {
}
class Solution228{
    public List<String> summaryRanges(int[] nums) {
        int length=nums.length;
        if(length==0)return new ArrayList<>();
        if(length==1)return Arrays.asList(Integer.toString(nums[0]));
        List<String> list=new ArrayList<>();
        String s="";
        int begin=nums[0];
        int last=nums[0];
        for(int i=1;i<length;i++){
            if(nums[i]==last+1){
                last=nums[i];
            }else{
                if(begin==last){
                    s=Integer.toString(last);
                }else{
                    s= begin +"->"+ last;
                }
                begin=nums[i];
                last=nums[i];
                list.add(s);
            }
        }
        if(begin==last){
            s=Integer.toString(last);
        }else{
            s= begin +"->"+ last;
        }
        list.add(s);
        return list;
    }
}