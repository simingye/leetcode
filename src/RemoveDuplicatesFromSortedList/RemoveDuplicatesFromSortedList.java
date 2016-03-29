package RemoveDuplicatesFromSortedList;

/**
 * Created by Siming on 6/1/15.
 */

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */
public class RemoveDuplicatesFromSortedList
{
    public ListNode deleteDuplicates (ListNode head)
    {
        if (head == null)
            return head;

        ListNode pointer1 = head.next;
        ListNode pointer2 = head;

        while (pointer1 != null)
        {
            if (pointer1.val != pointer2.val)
            {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            else
            {
                pointer2.next = pointer1.next;
                pointer1 = pointer1.next;
            }
        }

        return head;
    }
}
