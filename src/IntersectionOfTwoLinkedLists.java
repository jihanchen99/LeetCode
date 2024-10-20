public class IntersectionOfTwoLinkedLists {
    /*
    LeetCode 160:

    Given the heads of two singly linked lists headA and headB, return
    the node at which the two lists intersect. If the two linked lists
    have no intersection at all, return null.

    解题重点与思路：
    1. 两个链表的交点不是数值相等，而是指针相等（即指向内存中的同一个位置）。
    2. 设置两个指针，分别走一遍list A和list B，直到两个指针重合。
    3. 时间复杂度：O(m + n)， m、n分别为两链表的长度
       空间复杂度：O(1)，没有花费额外的空间

     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a_pointer = headA;
        ListNode b_pointer = headB;
        while(a_pointer != b_pointer){
            if (a_pointer == null){
                a_pointer = headB;
            } else {
                a_pointer = a_pointer.next;
            }
            if (b_pointer == null){
                b_pointer = headA;
            } else {
                b_pointer = b_pointer.next;
            }
        }
        return a_pointer;
    }

}
