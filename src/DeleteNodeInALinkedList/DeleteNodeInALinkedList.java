package DeleteNodeInALinkedList;

/**
 * Created by Siming on 10/28/15.
 */
public class DeleteNodeInALinkedList
{
    public void deleteNode(ListNode node)
    {
        if (node == null || node.next == null)
            return;

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        DeleteNodeInALinkedList test = new DeleteNodeInALinkedList();
        ListNode one = new ListNode(0);
        ListNode two = new ListNode(1);
        one.next = two;

        test.deleteNode(one);
    }
}
