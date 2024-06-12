public class T006 {
    public static void main(String[] args) {
        Solution006 s006=new Solution006();
        String res= s006.convert("A",1);
        System.out.println(res);
    }
}
class Solution006{
    public String convert(String s, int numRows) {
        int npt=numRows*2-2;
        if(numRows==1)return s;
        StringBuilder sb=new StringBuilder();
        char[] chs=s.toCharArray();
        int length=s.length();
//        int turns=length/npt;
//        int index=0;
        for(int i=0;i<numRows;i++){
            int index=0;
            while(index*npt+i<length){
                sb.append(chs[index*npt+i]);
                index++;
                if(i!=0&&i!=numRows-1&&index*npt-i<length){
                    sb.append(chs[index*npt-i]);
                }
            }
//            index=1;
//            while(i!=0&&i!=numRows-1&&index*npt-i<length){
//
//            }
        }
        return sb.toString();
    }
}