import java.util.ArrayList;
import java.util.List;

public class T68 {
}
class Solution68{
    public List<String> fullJustify(String[] words, int maxWidth) {
        int length=words.length;
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        int index=0;
        while(true){
            int nowLength=0;
            int nums=0;
            boolean isFinish=false;
            for(int i=index;i<=length&&nowLength<=maxWidth+1;i++){
                if(i==length){
                    isFinish=true;
                    break;
                }
                if(nowLength+words[i].length()<=maxWidth){
                    nowLength+= words[i].length()+1;
                    nums++;
                }else{
                    break;
                }
            }
            nowLength--;//È¥µôÄ©Î²µÄ¿Õ¸ñ
            sb=new StringBuilder();
            if(isFinish){
                for(int i=index;i<length;i++){
                    sb.append(words[i]);
                    if(i!=length-1){
                        sb.append(" ");
                    }
                }
                sb.append(" ".repeat(maxWidth-sb.length()));
                res.add(sb.toString());
                break;
            }
            if(nums==1){
                sb.append(words[index]);
                sb.append(" ".repeat(Math.max(0, Math.max(maxWidth - nowLength,0))));
                res.add(sb.toString());

                index++;
                continue;
            }

            int avgBlank=(maxWidth-nowLength)/(nums-1);
            int leftBlankNums=(maxWidth-nowLength)%(nums-1);
            for(int i=0;i<nums;i++){
                sb.append(words[index+i]);
                if(i<leftBlankNums){
                    sb.append(" ".repeat(avgBlank+2));
                }else if(i!=nums-1){
                    sb.append(" ".repeat(avgBlank+1));
                }
            }
            index+=nums;
            res.add(sb.toString());
        }
        return res;
    }
}