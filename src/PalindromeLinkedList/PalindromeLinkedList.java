package PalindromeLinkedList;

/**
 * Created by SimingYe on 1/11/16.
 */
public class PalindromeLinkedList
{
    public boolean isPalindrome(ListNode head)
    {
        if (head == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secHead = slow.next;
        slow.next = null;

        //reverse linked list
        ListNode p1 = secHead;
        ListNode p2 = p1.next;

        while (p2 != null)
        {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        secHead.next = null;

        ListNode p = (p2 == null ? p1 : p2);
        ListNode q = head;

        while (p != null)
        {
            if (p.val != q.val)
                return false;

            p = p.next;
            q = q.next;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList test = new PalindromeLinkedList();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
//        ode(3);
//        ListNode four = new e(2);
//        ListNode five = new e(1);

        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;

        System.out.println(test.isPalindrome(one));
    }
}


