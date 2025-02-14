/**
 * @author ZhangYihe
 * @since 2025/2/14
 **/
public class T299 {
}

class Solution299{

    public String getHint(String secret, String guess) {
        char[] secretC=secret.toCharArray();
        char[] guessC=guess.toCharArray();
        int slength=secretC.length;
        int glength=guessC.length;
        int bowNum=0;
        for(int i=0;i<Math.min(slength,glength);i++){
            if(secretC[i]==guessC[i]){
                secretC[i]='#';
                guessC[i]='#';
                bowNum++;
            }
        }
        int[] charNumS=new int[10];
        int[] charNumG=new int[10];
        for(int i=0;i<slength;i++){
            if(secretC[i]!='#'){
                charNumS[secretC[i]-'0']++;
            }
        }
        for(int i=0;i<glength;i++){
            if(guessC[i]!='#'){
                charNumG[guessC[i]-'0']++;
            }
        }
        int cowNum=0;
        for(int i=0;i<10;i++){
            cowNum+=Math.min(charNumS[i],charNumG[i]);
        }
        return bowNum+"A"+cowNum+"B";
    }

}