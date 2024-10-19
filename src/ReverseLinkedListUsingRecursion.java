public class ReverseLinkedListUsingRecursion {
    /*
    LeetCode 206:

    Given the head of a singly linked list, reverse the list, and return the
    reversed list.

     */
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(temp, cur);
    }
}
