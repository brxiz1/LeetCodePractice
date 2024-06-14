import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T030 {
    public static void main(String[] args) {
        Solution030 s30=new Solution030();
        List<Integer> list=s30.findSubstring("barfoofoobarthefoobarman",new String[]{"bar","foo","the"});
        System.out.println(list.toString());
    }
}
class Solution030{
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength= words[0].length();
        int wordsNum=words.length;
        int length=s.length();
        int win=wordsNum*wordLength;
        char[] ch=s.toCharArray();
        if(wordLength*wordsNum>length)return new ArrayList<Integer>();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<wordLength;i++){//起始位置
            //用hashMap代替check是否更好
            int[] check=new int[wordsNum];
            Map<String,Integer> map=new HashMap<>();
            for(String word:words){
                map.put(word,map.getOrDefault(word,0)+1);
            }
            if(isSubString(words,s,i,wordsNum,wordLength,map,length)){
                list.add(i);
            }
            for(int j=i;j<length;j+=wordLength){
                if(isNewArrSubString(words,s,j,wordsNum,wordLength,map,length)){
                    list.add(j+wordLength);
                }
            }
        }
        return list;

    }
    public boolean isSubString(String[] words,String s,int start,
                               int wordsNum,int wordLength,Map<String,Integer> check,int length){
        //未考虑越界
        for(int i=0;i<wordsNum;i++){
            if(start+(i+1)*wordLength>length){
                return false;//子串末尾后是原串结尾也可以
            }
//            for(int j=0;j<wordsNum;j++){
//
//                if(check[j]==0&&words[j].equals(s.substring(start+i*wordLength,start+(i+1)*wordLength))){
//                    check[j]++;
//                    break;
//                }
//            }
            String str=s.substring(start+i*wordLength,start+(i+1)*wordLength);
            if(check.containsKey(str)){
                check.put(str,check.get(str)-1);
            }
        }
        for(String str:check.keySet()){
            if(check.get(str)!=0)return false;
        }
        return true;
    }

    public boolean isNewArrSubString(String[] words,String s,int frontIndex,
                                     int wordsNum,int wordLength,Map<String,Integer> check,int length){
        if(frontIndex+wordLength*(wordsNum+1)>length){//如果当前已到末尾，则不能继续后移
            return false;
        }
//        for(int i=0;i<wordsNum;i++){
//
////            if(check[i]>0&&words[i].equals(s.substring(frontIndex,frontIndex+wordLength))){
////                check[i]--;//是否一定要在check[i]>0处-1？
////                break;
////            }
//
//        }
        String substr=s.substring(frontIndex,frontIndex+wordLength);
        if(check.containsKey(substr)){
            check.put(substr,check.get(substr)+1);
        }
//        int numsOfSameWords=0;
//        int index=-1;
//        for(int i=0;i<wordsNum;i++){
////            if(frontIndex+(wordsNum+1)*wordLength>length)break;
////            if(words[i].equals(s.substring(
////                    frontIndex+wordsNum*wordLength,frontIndex+(wordsNum+1)*wordLength))){
////                if(check[i]<=numsOfSameWords){
////                    index=i;
////                    numsOfSameWords=check[i];//选取check值最小的index，
////                }
////            }
//
//        }
        substr=s.substring(
                frontIndex+wordsNum*wordLength,frontIndex+(wordsNum+1)*wordLength);
        if(check.containsKey(substr)){
            check.put(substr,check.get(substr)-1);
        }
//        if(index!=-1)check[index]++;
        for(String key: check.keySet()){
            if(check.get(key)!=0)return false;
        }
        return true;
    }

}