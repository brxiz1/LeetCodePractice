import java.util.Scanner;

public class HuaweiT1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int total=0;
        int cola=0;
//        int bottom=0;
        while(sc.hasNext()){
            int newBottom=sc.nextInt();
            if(newBottom==0){
                break;
            }
            while(newBottom>2){
                cola=newBottom/3;
                newBottom=newBottom%3+cola;
                total+=cola;
                cola=0;
            }
            if(newBottom==2){
                total++;
            }
            System.out.println(total);
            total=0;
        }

    }
}
