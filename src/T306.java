/**
 * @author ZhangYihe
 * @since 2025/2/15
 **/
public class T306 {
    public static void main(String[] args) {
        Solution306 s306=new Solution306();
        boolean res=s306.isAdditiveNumber("011112");
        System.out.println(res);
    }
}

class Solution306{
    char[] str;
    public boolean isAdditiveNumber(String num) {
        str=num.toCharArray();
        for(int s2=1;s2<str.length-1;s2++){
            if(str[0]=='0'&&s2!=1)break;
            for(int e2=s2;e2<str.length-1;e2++){
                if(str[s2]=='0'&&e2!=s2)continue;
                if(search(0,s2,e2)){
                    return true;
                }
            }
        }
        return false;
    }
    //返回值char[]的开头可能是0，需要去掉
    public char[] stringAdd(int s1,int e1,int s2,int e2){
        int resLength=Math.max(e1-s1,e2-s2)+2;
        char[] res=new char[resLength];
        int up=0;
        for(int i=0;i<resLength;i++){
            int r=up;
            if(e1-i<s1&&e2-i<s2){

            }else if(e1-i<s1){
                r+=str[e2-i]-'0';
//                res[i]=str[s2+i];
//                continue;
            }else if(e2-i<s2){
                r+=str[e1-i]-'0';
//                res[i]=str[s1+i];
//                continue;
            }else{
                r+=str[e2-i]-'0'+str[e1-i]-'0';
            }

            if(r>9){
                up=1;
                r%=10;
            }else{
                up=0;
            }
            res[resLength-1-i]=(char)(r+'0');
        }
        return res;
    }

    public boolean search(int s1,int s2,int e2){
        //这里计算99+100错误
        char[] res=stringAdd(s1,s2-1,s2,e2);
        //去除res前缀0
        int resStartIndex=0;
        for(;resStartIndex<res.length-1;resStartIndex++){
            if(res[resStartIndex]!='0'){
                break;
            }
        }

        //注意这里e3有可能超过string的末尾
        int s3=e2+1,e3=e2+res.length-resStartIndex;
        if(s3>=str.length||str[s3]=='0'&&e3>s3||e3>=str.length){
            return false;
        }
        if(isSame(s3,e3,res,resStartIndex)){
            if(e3==str.length-1)return true;
            return search(s2,s3,e3);
        }
        return false;
    }

    public boolean isSame(int s1,int s2,char[] res,int resStartIndex){
        if(s2-s1+1!=res.length-resStartIndex)return false;
        for(int i=0;i<res.length-resStartIndex;i++ ){
            if(res[resStartIndex+i]!=str[s1+i])return false;
        }
        return true;
    }

}