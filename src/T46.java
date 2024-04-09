import java.util.ArrayList;
import java.util.List;

public class T46 {
    public static void main(String[] args) {
        Solution46 s46=new Solution46();
        System.out.println(s46.permute(new int[]{}));
    }
}
class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lli=new ArrayList<List<Integer>>();
        ArrayList<Integer> list=new ArrayList<>();

        int length=nums.length;
        for(int i :nums){
            list.add(i);
        }
        if(length!=0)lli.add(new ArrayList<>(list));
        listCreate(lli,list,0,length);
//        listCreate(lli,list,1,length);
        return lli;
    }
    public void listCreate(List<List<Integer>> lli,ArrayList<Integer> list,int index,int length){
        if(index>=length)return;
        int temp=list.get(index);
        listCreate(lli,list,index+1,length);
        for(int i=index+1;i<length;i++){

            list.set(index,list.get(i));
            list.set(i,temp);
            lli.add(new ArrayList<>(list));
            listCreate(lli,list,index+1,length);
            list.set(i,list.get(index));
            list.set(index,temp);
        }
    }
}
