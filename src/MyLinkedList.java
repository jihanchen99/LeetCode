import java.util.List;

class MyLinkedList {
    /*
    LeetCode 707:
    Design your implementation of the linked list. You can choose to use a
    singly or doubly linked list. A node in a singly linked list should have
    two attributes: val and next. val is the value of the current node, and
    next is a pointer/reference to the next node. If you want to use the doubly
    linked list, you will need one more attribute prev to indicate the previous
    node in the linked list. Assume all nodes in the linked list are 0-indexed.
     */

    int size;
    ListNode head; //虚拟头节点

    // Initializes the MyLinkedList Object
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    // Get the value of the index-th node in the linked list. If the index is
    // invalid, return -1
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    // Add a node of value val before the first element of the linked list.
    // After the insertion, the new node will be the first node of the linked
    // list.
    public void addAtHead(int val) {
        ListNode new_head = new ListNode(val);
        new_head.next = head.next;
        head.next = new_head;
        size++;
    }

    // Append a node of value val as the last element of the linked list.
    public void addAtTail(int val) {
        ListNode new_tail = new ListNode(val);
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new_tail;
        size++;
    }

    // Add a node of value val before the index-th node in the linked list. If
    // index equals the length of the linked list, the node will be appended to
    // the end of the linked list. If index is greater than the length, the node
    // will not be inserted.
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = cur.next;
        cur.next = toAdd;
        size++;
    }

    // Delete the index-th node in the linked list, if the index is valid.
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}
