public class T014 {
}
class Solution14{
    public String longestCommonPrefix(String[] strs) {
        String res=strs[0];

        int end=res.length();
        int length= strs.length;
        for(int i=1;i<length;i++){
            int sl=Math.min(strs[i].length(),end);
            end=sl;
            for(int j=0;j<sl;j++){
                if(res.charAt(j)!=strs[i].charAt(j)){
                    end=j;
                    break;
                }
            }

            if(end==0){
                return "";
            }
        }
        return res.substring(0,end);
    }
}