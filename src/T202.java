public class T202 {

}
class Solution202{
    public boolean isHappy(int n) {
        int quick=nextNum(nextNum(n));
        int slow=nextNum(n);
        while(quick!=slow){
            if(quick==1)return true;
            quick=nextNum(nextNum(quick));
            slow=nextNum(slow);
        }
        if(slow==1)return true;
        else return false;
    }
    public int nextNum(int n){
        int res=0;
        while(n>0){
            res+= (int) Math.pow(n%10,2);
            n=n/10;
        }
        return res;
    }
}