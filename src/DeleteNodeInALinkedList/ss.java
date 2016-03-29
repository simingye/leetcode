package DeleteNodeInALinkedList;

/**
 * Created by SimingYe on 3/5/16.
 */
public class ss
{
    public int getNode(ListNode head)
    {
        ListNode node = new ListNode(-1);
        node.next = head;
        head = head.next;

        return node.next.val;
    }

    public static void main(String[] args) {
        ss test = new ss();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;

        System.out.println(test.getNode(one));
    }
}
