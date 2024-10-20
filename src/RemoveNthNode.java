public class RemoveNthNode {
    /*
    LeetCode 19:

    Given the head of a linked list, remove the nth node from the end of the
    list and return its head.

     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyhead = new ListNode(0, head);
        ListNode fast = dummyhead;
        ListNode slow = dummyhead;

        // 先让快指针走n+1步。n+1是因为想让快指针多走一步，这样慢指针可以正好指向倒数第n-1个节点。
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        // 快慢指针同时向前走，直到快指针指向null（意味着已经到底链表结尾）。
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除倒数第n个节点
        ListNode temp = slow.next.next;
        slow.next = temp;
        // 通过虚拟头指针.next来返回真正的头节点
        return dummyhead.next;
    }
}
