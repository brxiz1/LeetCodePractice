import java.util.*;

public class T380 {
    public static void main(String[] args) {

    }

}
class RandomizedSet {
    Map<Integer,Integer> map=new HashMap<>();
    List<Integer> list=new ArrayList<>(1000);
    int lastIndex;
    public RandomizedSet() {
        lastIndex=-1;
    }

    public boolean insert(int val) {
        if(map.containsKey(val))return false;

        lastIndex++;
        list.add(val);
        map.put(val,lastIndex);
        return true;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index=map.get(val);
            int lastVal=list.get(lastIndex);

            list.set(index,lastVal);
            list.remove(lastIndex);
            lastIndex--;

            map.put(lastVal,index);
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        Random r=new Random();

        return list.get(r.nextInt(0,lastIndex+1));
    }
}