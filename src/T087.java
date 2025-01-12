/**
 * @author ZhangYihe
 * @since 2025/1/9
 **/
public class T087 {
    public static void main(String[] args) {
        Solution87 s87=new Solution87();
        boolean res=s87.isScramble("great","rgeat");
        System.out.println(res);
    }
}

class Solution87{
    int[][][] checkBox;
    public boolean isScramble(String s1, String s2) {
        checkBox=new int[s1.length()][s2.length()][s1.length()];
        return search(s1,s2,0,0,s1.length());
    }

    public boolean search(String s1,String s2,int i1,int i2,int length){

        if(checkBox[i1][i2][length-1]!=0){
            return checkBox[i1][i2][length-1]==1;
        }
        if(length==1){
            return s1.charAt(i1)==s2.charAt(i2);
        }
        if(s1.substring(i1,i1+length).equals(s2.substring(i2,i2+length))){
            return true;
        }
        if(!hasSameComponent(s1,s2,i1,i2,length))return false;
        boolean res=false;
        for(int l=0;l<length-1;l++){

            res=res||search(s1,s2,i1,i2,l+1)&&search(s1,s2,i1+l+1,i2+l+1,length-1-l);

            res=res||search(s1,s2,i1,i2+(length-1-l),l+1)&&search(s1,s2,i1+1+l,i2,length-(l+1));
        }
        checkBox[i1][i2][length-1]=res?1:-1;
        return res;
    }
    public boolean hasSameComponent(String s1,String s2,int i1,int i2,int length){
        int[] chNum=new int[26];
        for(int j1=0,j2=0;j1<length&&j2<length;j1++,j2++){
            chNum[s1.charAt(i1+j1)-'a']++;
            chNum[s2.charAt(i2+j2)-'a']--;
        }
        for(int n:chNum){
            if(n!=0)return false;
        }
        return true;
    }
}