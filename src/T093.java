import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2025/1/9
 **/
public class T093 {
}
class Solution93{
    List<String> res=new ArrayList<>();
    String s;
    public List<String> restoreIpAddresses(String s) {
        this.s=s;
        search(new StringBuilder(),0,0);
        return res;
    }

    public void search(StringBuilder sb,int segmentNo,int index){
        if(s.length()-index-1>(4-segmentNo)*3)return;
        if(segmentNo>=4){
            if(index==s.length()){

                res.add(sb.toString());
            }
            return;
        }
        if(index>=s.length())return;
        if(s.charAt(index)=='0'){
            if(segmentNo<3){
                sb.append("0.");
            }else{
                sb.append("0");
            }
            search(sb,segmentNo+1,index+1);
            if(segmentNo<3){
                sb.replace(sb.length()-2,sb.length(),"");
            }else{
                sb.replace(sb.length()-1,sb.length(),"");
            }
            return;
        }
        int segNum=0;

        for(int i=0;i<3&&index+i<s.length();i++){
            segNum=segNum*10+s.charAt(index+i)-'0';
            if(segNum>255)break;

            if(segmentNo<3){
                sb.append(segNum).append(".");
            }else{
                sb.append(segNum);
            }

            search(sb,segmentNo+1,index+1+i);

            if(segmentNo<3){
                sb.replace(sb.length()-(i+2),sb.length(),"");
            }else{
                sb.replace(sb.length()-(i+1),sb.length(),"");
            }

        }
    }
}