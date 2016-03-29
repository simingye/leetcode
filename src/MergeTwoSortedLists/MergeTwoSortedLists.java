package MergeTwoSortedLists;

/**
 * Created by Siming on 5/27/15.
 */

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists
{
    public ListNode mergeTwoLists (ListNode l1, ListNode l2)
    {
        ListNode result = new ListNode(0);

        if (l1 == null && l2 == null)
            return null;

        if (l1 == null && l2 != null)
            return l2;

        if (l1 != null && l2 == null)
            return l1;

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode root = result;

        while (temp1 != null && temp2 != null)
        {
            if (temp1.val <= temp2.val)
            {
                root.next = temp1;
                temp1 = temp1.next;
            }
            else
            {
                root.next = temp2;
                temp2 = temp2.next;
            }
            root = root.next;
        }

        if (temp1 == null)
        {
            root.next = temp2;
        }

        if (temp2 == null)
        {
            root.next = temp1;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        MergeTwoSortedLists test = new MergeTwoSortedLists();
        test.mergeTwoLists(l1, l2);
    }
}
