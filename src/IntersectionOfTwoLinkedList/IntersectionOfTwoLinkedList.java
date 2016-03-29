package IntersectionOfTwoLinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Siming on 10/30/15.
 */
public class IntersectionOfTwoLinkedList
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if (headA == null || headB == null)
            return null;

        Set<ListNode> set = new HashSet<>();

        while (headA != null || headB != null)
        {
            if (set.contains(headA))
            {
                return headA;
            }
            else
            {
                if (headA != null)
                {
                    set.add(headA);
                    headA = headA.next;
                }
            }

            if (set.contains(headB))
            {
                return headB;
            }
            else
            {
                if (headB != null)
                {
                    set.add(headB);
                    headB = headB.next;
                }
            }
        }

        return null;
    }
}
