public class T32 {
    public static void main(String[] args) {
        Solution32 s32=new Solution32();
        System.out.println(s32.longestValidParentheses(""));
    }
}
class Solution32 {
    public int longestValidParentheses(String s) {
        char[] str=s.toCharArray();
        int left=0;
        int right=0;
        int max=0;
        for(int i=0;i<str.length;i++){
            if (str[i] == '(') {
                left++;
            }else{
                right++;
            }
            if(left<right){
                left=0;
                right=0;
                continue;
            }else if(left==right&&left!=0){
                max=Math.max(left*2,max);
//                left=0;
//                right=0;
            }
        }
        left=0;
        right=0;
        for(int i=str.length-1;i>=0;i--){
            if (str[i] == '(') {
                left++;
            }else{
                right++;
            }
            if(left>right){
                left=0;
                right=0;
            }else if(left==right&&left!=0){
                max=Math.max(right*2,max);
            }
        }
        return max;
    }
}
