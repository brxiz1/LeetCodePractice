import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangYihe
 * @since 2024/9/13
 **/
public class T133 {

}
class Solution133{
    public Node133 cloneGraph(Node133 node) {
        if(node==null)return null;

        Map<Integer,Node133> map=new HashMap<>();

        Node133 newNode=new Node133(node.val);
        map.put(newNode.val,newNode);
        dps(node,map,newNode);
        return newNode;
    }
    public void dps(Node133 node, Map<Integer,Node133> map,Node133 newNode){
        for(Node133 n:node.neighbors){
            if(map.containsKey(n.val)){
                newNode.neighbors.add(map.get(n.val));
            }else{
                Node133 nn=new Node133(n.val);
                map.put(nn.val,nn);
                dps(n,map,nn);
                newNode.neighbors.add(nn);
            }
        }
    }
}
class Node133{
    public int val;
    public List<Node133> neighbors;
    public Node133() {
        val = 0;
        neighbors = new ArrayList<Node133>();
    }
    public Node133(int _val) {
        val = _val;
        neighbors = new ArrayList<Node133>();
    }
    public Node133(int _val, ArrayList<Node133> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}