public class T406 {
    public static void main(String[] args) {
        int[][] people=new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        Solution406 s406=new Solution406();
        int[][] res=s406.reconstructQueue(people);
        System.out.println(res);
    }
}
class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        int length=people.length;
        quickSort(people,0,people.length-1);
        int[][] res=new int[length][2];
        for(int[] re:res){
            re[0]=-1;
        }
        for(int i=0;i<length;i++){
            int nums=people[i][1];
            int index=0;
            for(int j=0;j<length;j++){
                if(res[j][0]==-1){
                    if(nums==0){
                        index=j;
                        break;
                    }
                    nums--;

                }
                if(j==length-1){
                    index=j;
                }

            }
            res[index][0]=people[i][0];
            res[index][1]=people[i][1];
        }
        return res;
    }
    public void quickSort(int[][] people,int left,int right){
        if(left>=right)return;
        int checkIndex=right;
        int start=left-1;
        for(int i=left;i<right;i++){
            if(people[i][0]<people[checkIndex][0]||people[i][0]==people[checkIndex][0]&&people[i][1]>people[checkIndex][1]){
                start++;
                change(people,start,i);
            }
        }
        change(people,right,start+1);
        quickSort(people,left,start);
        quickSort(people,start+2,right);
    }
    public void change(int[][] people,int index1,int index2){
        int temp0=people[index1][0];
        int temp1=people[index1][1];
        people[index1][0]=people[index2][0];
        people[index1][1]=people[index2][1];
        people[index2][0]=temp0;
        people[index2][1]=temp1;
    }
}