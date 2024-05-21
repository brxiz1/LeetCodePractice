public class T338 {
}

class Solution338{
    public int[] countBits(int n) {
        int checkNum=2;
        int[] res=new int[n+1];
        if(n==0)return res;
        res[1]=1;
        if(n==1) return res;
        res[2]=1;
        for(int i=2;i<n+1;i++){
            res[i]=res[i%checkNum]+1;
            if(i%checkNum==0){
                checkNum=i;
            }
        }
        return res;
    }
}