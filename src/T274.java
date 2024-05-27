public class T274 {

}
class Solution274{
    public int hIndex(int[] citations) {
        int max=0;
        int length=citations.length;
        for(int i=0;i<length;i++){
            max=Math.max(citations[i],max);
        }
        int[] nums=new int[max+1];//index��������
        for(int i=0;i<length;i++){
            nums[citations[i]]++;
        }
        int h=0;
        for(int i=max;i>=0;i--){
            if(i>h){
                h=Math.min(nums[i]+h,i);//Ҫ���ǵ�h+nums[i]���Ѿ�����i�Ŀ�����
            }else{
                break;
            }

        }
        return h;
    }
    public int hIndex2(int[] citations){
        int max=0;
        int min=1000;
        int length=citations.length;
        for(int i=0;i<length;i++){
            max=Math.max(max,citations[i]);
            min=Math.min(min,citations[i]);
        }
        int r=max;
        int l=min;
        //���������ı߽��ж�̫������
        while(l<r){
            int mid=(r+l+1)/2;
            int nums=0;
            for(int i=0;i<length;i++){
                if(citations[i]>=mid){
                    nums++;
                }
            }
            if(nums>=mid){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return l;
    }
}
