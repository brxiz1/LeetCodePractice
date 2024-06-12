public class T012 {

}
class Solution12{
    public String intToRoman(int num) {
        int[] list=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] ch=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i=0;
        StringBuilder sb=new StringBuilder();
        while(num>0){
            if(num<list[i]){
                i++;
                continue;
            }
            num-=list[i];
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}