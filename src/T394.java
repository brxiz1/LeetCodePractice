public class T394 {
    public static void main(String[] args) {
        Solution394 s394=new Solution394();
        System.out.println(s394.decodeString("3[ab1[zc]2[xy]]"));
    }
}
class Solution394{
    public String decodeString(String s) {
        StringBuilder res=new StringBuilder();
        int r=search(s,0,res);
        return res.toString();
    }
    public int search(String s,int index,StringBuilder res){
        StringBuilder r= new StringBuilder();
//        res="a";
        int num=0;
        int nextIndex=0;
//        res.append("a");
        for(int i=index;i<s.length();i++){
            char c=s.charAt(i);
            if(s.charAt(i)==']'){
                nextIndex=i+1;
                break;
            }else if(c>='0'&&c<='9'){
                num=num*10+(c-'0');
            }else if(c=='['){
                StringBuilder nextStr=new StringBuilder();
                nextIndex=search(s,i+1,nextStr);
                res.append(r);
                r=new StringBuilder();

                for(int j=0;j<num;j++){
                    res.append(nextStr);
                }
                num=0;
                i=nextIndex-1;

                continue;
            }else{
                r.append(c);
            }
        }
        res.append(r);
        return nextIndex;
    }
}
