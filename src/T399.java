import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class T399 {
    public static void main(String[] args) {
        double[] d1=new double[1];
        d1[0]=0.0;
        change(d1);
        System.out.println(d1[0]);
    }
    public static void change(double[] d1){
        d1[0]=1.0;
    }
}

class Solution399{
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Coll coll=new Coll();
        coll.init(equations,values);
        int length=queries.size();
        double[] res=new double[length];
        String f0,f1;
        double[] val0=new double[1];
        double[] val1=new double[1];

        for(int i=0;i<length;i++){
            String q0=queries.get(i).get(0);
            String q1=queries.get(i).get(1);
            f0=coll.find(q0,val0);
            f1=coll.find(q1,val1);
            if(f0==null||f1==null){
                res[i]=-1;
                continue;
            }
            if(f0.equals(f1)){
                res[i]=val1[0]/val0[0];
            }else{
                res[i]=-1;
            }
        }
        return res;
    }

}
class Coll{
    Map<String,String> preMap=new HashMap<>();//0->1
    Map<String,Double> valMap=new HashMap<>();//节点权值
    Map<String,Integer> levelMap=new HashMap<>();
    void join(String s1,String s2,double val){
        double[] d1=new double[1];
        double[] d2=new double[1];
        String f1=find(s1,d1);
        String f2=find(s2,d2);
        if(f1==null){
            preMap.put(s1,s1);
            f1=s1;
            valMap.put(s1,1.0);
            levelMap.put(s1,1);
        }
        if(f2==null){
            preMap.put(s2,s2);
            f2=s2;
            valMap.put(s2,1.0);
            levelMap.put(s2,1);
        }
        if(!f1.equals(f2)){
            if(levelMap.get(f1)>levelMap.get(f2)){
                preMap.put(f2,f1);
                valMap.put(f2,d1[0]/d2[0]/val);
            }else{
                preMap.put(f1,f2);
                if(Objects.equals(levelMap.get(f1), levelMap.get(f2))){
                    levelMap.put(f2,levelMap.get(f2)+1);
                }
                valMap.put(f1,val*d2[0]/d1[0]);
            }
        }
    }
    String find(String s1,double[] prevValue){
        if(!preMap.containsKey(s1)){
            prevValue[0]=1;
            return null;
        }
        if(preMap.get(s1).equals(s1)){
            prevValue[0]=valMap.get(s1);
            return s1;
        }else{
            double[] pv=new double[1];
            String res=find(preMap.get(s1),pv);
            valMap.put(s1,valMap.get(s1)*pv[0]);
            preMap.put(s1,res);
            prevValue[0]=valMap.get(s1);
            return res;
        }
    }
    void init(List<List<String>> equations, double[] values){
        int length=values.length;
        for(int i=0;i<length;i++){
            String s1=equations.get(i).get(1);
            String s0=equations.get(i).get(0);
            join(s1,s0,values[i]);
//            preMap.put(s1,s0);
//
//            valMap.put(s1,values[i]);
//            if(!preMap.containsKey(s0)){
//                preMap.put(s0,s0);
//                valMap.put(s0,1.0);
//            }
        }
    }
}