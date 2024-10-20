public class SwapNodesInPairs {
    /*
    LeetCode 24:

    Given a linked list, swap every two adjacent nodes and return its head.
    You must solve the problem without modifying the values in the list's
    nodes. Only nodes themselves may be changed

     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyhead = new ListNode();
        dummyhead.next = head;
        ListNode cur = dummyhead;

        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;               // 保存节点1
            ListNode temp1 = cur.next.next.next;    // 保存节点3
            cur.next = cur.next.next;               // dummyhead指向节点2
            cur.next.next = temp;                   // 节点2指向节点1
            temp.next = temp1;                      // 节点1指向节点3
            cur = cur.next.next;                    // 让cur指针指向下一组节点之前的一个节点
        }

        return dummyhead.next;
    }

    /*
    Key Points:
    1. 遍历的终止条件
    2. 两两交换的逻辑：定义cur指针，来操作两两交换。cur指针指向要交换的两个节点的前一个节点。
    3. 使用虚拟头节点：通过虚拟头节点来改变真正的头节点，方便最终返回（head = dummyhead.next）。
     */
}
