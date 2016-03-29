package RemoveLinkedListElements;

/**
 * Created by Siming on 6/19/15.
 */
public class RemoveLinkedListElements
{
    public  ListNode removeElements (ListNode head, int val)
    {
        if (head == null)
            return null;

        ListNode current = head.next;
        ListNode previous = head;
        ListNode newHead = head;

        while ( current != null)
        {
            if (current.val == val)
            {
                previous.next = current.next;
                current = current.next;
            }
            else
            {
                current = current.next;
                previous = previous.next;
            }
        }

        while (newHead != current)
        {
            if (newHead.val == val)
            {
                newHead = newHead.next;
            }
            else
            {
                return newHead;
            }
        }

        return newHead;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements test = new RemoveLinkedListElements();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        System.out.println(test.removeElements(node1,1));
    }
}
