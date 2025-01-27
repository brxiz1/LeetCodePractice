/**
 * @author ZhangYihe
 * @since 2025/1/27
 **/
public class T165 {


    public static void main(String[] args) {
        Solution165 s165=new Solution165();
        String s1="1.0.1";
        String s2="1";
        int res=s165.compareVersion(s1,s2);
        System.out.println(res);
    }
}

class Solution165{
    int index1=0;
    int index2=0;
    public int compareVersion(String version1, String version2) {
        int length1=version1.length();
        int length2=version2.length();

        while (index1 != length1 || index2 != length2) {
            //不断调用getNum,直到双方都达到尾部
            int num1 = getNextNum(version1, index1, true);
            int num2 = getNextNum(version2, index2, false);
            if (num1 < num2) return -1;
            else if (num1 > num2) return 1;
        }
        return 0;
    }

    public int getNextNum(String version,int index,boolean check){
        int res=0;
        while(index<version.length()){
            if(version.charAt(index)=='.'){
                index++;
                break;
            }
            res=res*10+version.charAt(index)-'0';
            index++;

        }
        if(check)index1=index;
        else index2=index;
        return res;
    }
}
