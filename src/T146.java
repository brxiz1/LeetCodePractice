import java.util.HashMap;
import java.util.Map;

public class T146 {
}
class LRUCache{
    Node nullHead;
    Node nullTail;
    Map<Integer,Node> map=new HashMap<>();
    int capacity;
    int numsNow;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        numsNow=0;
        nullHead=new Node();
        nullTail=new Node();
        nullHead.next=nullTail;
        nullTail.front=nullHead;

    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n=map.get(key);
            deleteN(n);
            moveToHead(n);
            return n.value;
        }else{
            return -1;
        }
    }
//public int get(int key) {
//    Node node = map.get(key);
//    if (node == null) {
//        return -1;
//    }
//    // 如果 key 存在，先通过哈希表定位，再移到头部
//    moveToHead(node);
//    return node.value;
//}


    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n=map.get(key);
            n.value=value;
            deleteN(n);
            moveToHead(n);
        }else{
            if(numsNow==capacity){
                Node tail=nullTail.front;

                deleteN(nullTail.front);
//                Node tail=removeTail();
                map.remove(tail.key);
                numsNow--;
            }
            Node n=new Node(key,value);

            moveToHead(n);
            map.put(key,n);
//            addToHead(n);
            numsNow++;
        }
    }
//public void put(int key, int value) {
//    Node node = map.get(key);
//    if (node == null) {
//        // 如果 key 不存在，创建一个新的节点
//        Node newNode = new Node(key, value);
//        // 添加进哈希表
//        map.put(key, newNode);
//        // 添加至双向链表的头部
//        addToHead(newNode);
//        ++numsNow;
//        if (numsNow > capacity) {
//            // 如果超出容量，删除双向链表的尾部节点
//            Node tail = removeTail();
//            // 删除哈希表中对应的项
//            map.remove(tail.key);
//            --numsNow;
//        }
//    }
//    else {
//        // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
//        node.value = value;
//        moveToHead(node);
//    }
//}

    public void moveToHead(Node n){
        n.front=nullHead;
        n.next=nullHead.next;
        nullHead.next.front=n;
        nullHead.next=n;
    }
    public void deleteN(Node n){
        n.front.next=n.next;
        n.next.front=n.front;
    }
//private void addToHead(Node node) {
//    node.front = nullHead;
//    node.next = nullHead.next;
//    nullHead.next.front = node;
//    nullHead.next = node;
//}
//
//    private void removeNode(Node node) {
//        node.front.next = node.next;
//        node.next.front = node.front;
//    }
//
//    private void moveToHead(Node node) {
//        removeNode(node);
//        addToHead(node);
//    }
//
//    private Node removeTail() {
//        Node res = nullTail.front;
//        removeNode(res);
//        return res;
//    }
    

}

class Node{
    int value;
    int key;
    Node front=null;
    Node next=null;
    Node(){

    }
    Node(int value,Node front,Node next,int key){
        this.key=key;
        this.value=value;
        this.front=front;
        this.next=next;
    }
    Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}