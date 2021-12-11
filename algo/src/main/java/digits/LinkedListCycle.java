package digits;

import digits.model.ListNode;

public class LinkedListCycle {


    public static void main(String[] args) {
        ListNode next4 = new ListNode(-4);
        ListNode next2 = new ListNode(2, new ListNode(0, next4));
        next4.next = next2;
        ListNode head = new ListNode(3, next2);
        System.out.println(hasCycle(head));


        ListNode next1 = new ListNode(2);
        head = new ListNode(1, next1);
        next1.next = head;
        System.out.println(hasCycle(head));


        head = new ListNode(1);
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // 快指针，一次两步
            slow = slow.next;  // 慢指针，一次一步
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
