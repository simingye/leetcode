package RemoveNthNodeFromEndOfList;

/**
 * Created by Siming on 5/26/15.
 */

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 */
public class RemoveNthNodeFromEndOfList
{
    public ListNode removeNthFromEnd (ListNode head, int n)
    {
        int length = 0;
        int target;
        int timer = 1;
        ListNode temp = head;
        ListNode current = head;
        ListNode next = head.next;

        while (temp != null)
        {
            length++;
            temp = temp.next;
        }

        if (n > length || n < 0)
            return null;

        if (length == n)
            return head.next;

        target = length - n + 1;

        while (current != null)
        {
            if (timer != target - 1)
            {
                current = next;
                next = next.next;
                timer++;
            }
            else
            {
                if (next.next == null)
                {
                    current.next = null;
                    break;
                }
                else
                {
                    current.next = next.next;
                    break;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
        head.next = node2;
//        node2.next = node3;
        RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();
        ListNode result = test.removeNthFromEnd(head, 2);
//        System.out.println(result.val);
        while (result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
