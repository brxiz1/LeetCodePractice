/**
 * @author ZhangYihe
 * @since 2024/12/29
 **/
public class T97 {
    public static void main(String[] args) {
        Solution97 s9=new Solution97();
        boolean res=s9.isInterleave("aabcc","dbbca","aadbbcbcac");
        System.out.println(res);
    }
}

class Solution97{
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        char[] c3=s3.toCharArray();
        int l1=c1.length;
        int l2=c2.length;
        int l3=c3.length;
        if(l1+l2!=l3)return false;
        boolean[] isLeave=new boolean[l2+1];
        isLeave[0]=true;
        for(int j=0;j<l2;j++){
            isLeave[j+1]=isLeave[j]&&c2[j]==c3[j];
        }
        for(int i=0;i<l1;i++){
            isLeave[0]=isLeave[0]&&c1[i]==c3[i];
            for(int j=0;j<l2;j++){
                isLeave[j+1]=isLeave[j+1]&&c1[i]==c3[i+j]
                        ||isLeave[j]&&c2[j]==c3[i+j];
            }
        }
        return isLeave[l2];
    }
}