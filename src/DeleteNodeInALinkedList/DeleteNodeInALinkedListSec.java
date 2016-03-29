package DeleteNodeInALinkedList;

import javax.xml.soap.Node;

/**
 * Created by Siming on 11/11/15.
 */
public class DeleteNodeInALinkedListSec
{
    public void deleteNode(ListNode node)
    {
        if (node == null || node.next == null)
            return;

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        DeleteNodeInALinkedListSec test = new DeleteNodeInALinkedListSec();
        test.deleteNode(three);
        System.out.println(one.val);
    }
}
