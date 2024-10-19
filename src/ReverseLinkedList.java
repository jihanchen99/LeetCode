public class ReverseLinkedList {
    /*
    LeetCode 206:

    Given the head of a singly linked list, reverse the list, and return the
    reversed list.

     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null; // This is because when the head becomes the tail
                             // it will point it NULL
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
