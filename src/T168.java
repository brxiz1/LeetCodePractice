/**
 * @author ZhangYihe
 * @since 2025/1/27
 **/
public class T168 {

}

class Solution168{
    public String convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder();
        while(columnNumber!=0){
            sb.append((char)((columnNumber-1)%26+'A'));
            columnNumber=(columnNumber-1)/26;
        }
        sb.reverse();
        return sb.toString();
    }
}
