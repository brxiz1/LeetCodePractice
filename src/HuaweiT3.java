import java.util.Scanner;

public class HuaweiT3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] ch=s.toCharArray();
        int res=0;
        int length=ch.length;
        for(int i=2;i<length;i++){
            if(ch[i]>='0'&&ch[i]<='9'){
                res+= (int) ((ch[i]-'0')*Math.pow(16,length-i-1));
            }
            if(ch[i]>='A'&&ch[i]<='F'){
                res+=(int) ((ch[i]-'A'+10)*Math.pow(16,length-i-1));
            }
        }
        System.out.println(res);
    }

}
