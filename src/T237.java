/**
 * @author ZhangYihe
 * @since 2025/2/3
 **/
public class T237 {
}
//神人题目
class Solution237{
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}