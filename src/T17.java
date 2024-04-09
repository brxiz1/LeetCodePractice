import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T17 {
    public static void main(String[] args) {
        Solution17 s17=new Solution17();
        List<String> ls=s17.letterCombinations("");
        System.out.println(ls.size());
        System.out.println(ls);
    }
}
class Solution17 {
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> dict=new HashMap<>();
        dict.put(2,"abc");
        dict.put(3,"def");
        dict.put(4,"ghi");
        dict.put(5,"jkl");
        dict.put(6,"mno");
        dict.put(7,"pqrs");
        dict.put(8,"tuv");
        dict.put(9,"wxyz");
        List<String> combinations=new ArrayList<>();
        StringBuilder combination=new StringBuilder();
//        char[] dig=digits.toCharArray();
        createCombination(0,combinations,combination,dict,digits);
        return combinations;
    }
    public void createCombination(int index,List<String> combinations,
                                  StringBuilder combination,Map<Integer,String> dict,String digits){
        if(digits.isEmpty())return;
        if(index>=digits.length()){
            combinations.add(String.valueOf(combination));
            return;
        }
        String res=dict.get(Integer.parseInt(digits.substring(index,index+1)));
        char[] re=res.toCharArray();
        for(char r:re){
            combination.append(r);
            createCombination(index+1,combinations,combination,dict,digits);
            combination.delete(index,index+1);
        }


    }
}
