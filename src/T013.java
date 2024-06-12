public class T013 {
}
class Solution013{
    public int romanToInt(String s) {
        int length=s.length();
        char[] ch=s.toCharArray();
        int res=0;
        for(int i=0;i<length;i++){
            switch(ch[i]){
                case 'M':
                    res+=1000;
                    break;
                case 'D':
                    res+=500;
                    break;
                case 'C':
                    if(i<length-1&&(ch[i+1]=='M'||ch[i+1]=='D')){
                        res-=100;
                    }else{
                        res+=100;
                    }
                    break;
                case 'L':
                    res+=50;
                    break;
                case 'X':
                    if(i<length-1&&(ch[i+1]=='C'||ch[i+1]=='L')){
                        res-=10;
                    }else{
                        res+=10;
                    }
                    break;
                case 'V':
                    res+=5;
                    break;
                case 'I':
                    if(i<length-1&&(ch[i+1]=='V'||ch[i+1]=='X')){
                        res-=1;
                    }else{
                        res+=1;
                    }
                    break;
            }

        }
        return res;
    }
}