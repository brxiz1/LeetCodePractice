import java.util.HashMap;
import java.util.Map;

public class T3 {
    public static void main(String[] args) {
        Solution3 s3=new Solution3();
        System.out.println(s3.lengthOfLongestSubstring("abcabcbb"));
    }
}
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] str=s.toCharArray();
        int left=0;
        int right=1;
        int length=str.length;
        int maxlength=0;
        while(true){
            if(left==length){
                return maxlength;
            }
            Map<Character,Integer> map=new HashMap<>();
            map.put(str[left],left);
            while(true){
                if(right==length){
//                    System.out.println(map);
                    return Math.max(maxlength,right-left);
                }
                if(!map.containsKey(str[right])){
                    map.put(str[right],right);
                    right++;
                }else{
                    if(right-left>maxlength){
                        maxlength=right-left;
                    }
                    left=map.get(str[right])+1;
//                    left++;
                    right=left+1;//注意这里要重置right，因为map再下一次循环重置后会信息丢失。
                    break;
                }
            }
        }
    }
}