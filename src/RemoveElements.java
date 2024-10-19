public class RemoveElements {
    /*
    LeetCode 203:
    Given the head of a linked list and an integer val, remove all the nodes
    of the linked list that has Node.val == val, and return the new head.

    First method: dealing with head nodes and non-head nodes separately
     */
    public ListNode removeElements(ListNode head, int val) {
        // Removing the head node, if head.val == val
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    /*
    Second method: using a dummy head
     */
    public ListNode removeElementsTwo(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
