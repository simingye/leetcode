package SwapNodesInPairs;

/**
 * Created by Siming on 8/28/15.
 */
public class SwapNodesInPairs
{
    public ListNode swapPairs(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode previous = preHead;
        ListNode current = head;
        ListNode next = head.next;

        while (next != null)
        {
            previous.next = next;
            current.next = next.next;
            next.next = current;

            previous = current;
            current = current.next;

            if (current == null)
            {
                next = null;
            }
            else
            {
                next = current.next;

            }
        }

        return preHead.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs test = new SwapNodesInPairs();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(test.swapPairs(node1));
    }
}
