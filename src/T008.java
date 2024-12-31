/**
 * @author ZhangYihe
 * @since 2024/12/29
 **/
public class T008 {
    public static void main(String[] args) {
        Solution008 s8=new Solution008();
        int res=s8.myAtoi("-21474836482");
        System.out.println(res);
    }
}
class Solution008{
    public int myAtoi(String s) {

        s=s.strip();
        if(s.isEmpty())return 0;
        char[] ctrs=s.toCharArray();
        boolean isPositive=true;

        if(ctrs[0]=='-'){
            isPositive=false;
        }else if(ctrs[0]!='+'&&!isNum(ctrs[0])){
            return 0;
        }
        int res=0;
        int i=1;
        if(isNum(ctrs[0]))i=0;
        boolean isFilled=false;
        //不应该试图先构建正数，再按照符号转为负数，因为Integer.MIN_VALUE是无法被正数表示的
        for(;i<ctrs.length;i++){
            if(!isNum(ctrs[i]))break;
            if(res<Integer.MIN_VALUE/10
                    ||res==Integer.MIN_VALUE/10
                        &&(ctrs[i]-'0'>8||isPositive&&ctrs[i]-'0'>7)){
                isFilled=true;
                break;
            }

            res=res*10-(ctrs[i]-'0');


        }
        if(isPositive)res*=-1;
        if(isFilled){
            res=isPositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return res;
    }

    public boolean isNum(char ch){
        return ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'
                ||ch=='6'||ch=='7'||ch=='8'||ch=='9'||ch=='0';
    }
}