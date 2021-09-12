package digits;

import digits.model.ListNode;

import java.util.ArrayList;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateList {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        int k = 2;
//        ListNode listNode = rotateRight(head, k);
//        print(listNode);
//        ListNode head1 = new ListNode(0, new ListNode(1, new ListNode(2)));
//        int k1 = 4;
//        ListNode listNode1 = rotateRight(head1, k1);
//        print(listNode1);
        ListNode head = new ListNode(1, new ListNode(2));
        int k = 2;
        ListNode listNode = rotateRight(head, k);
        print(listNode);
    }

    private static void print(ListNode listNode) {
        System.out.printf("," + listNode.val);
        while (listNode.next != null) {
            listNode = listNode.next;
            System.out.printf("," + listNode.val);
        }
        System.out.println("");
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ArrayList<ListNode> listNodes = new ArrayList<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            listNodes.add(temp);
            temp = temp.next;
        }
        listNodes.get(listNodes.size() - 1).next = listNodes.get(0);
        int nextLastIndex = (listNodes.size() - 1) - k % listNodes.size();
        ListNode nextLast = listNodes.get(nextLastIndex);
        ListNode nextHead = nextLast.next;
        nextLast.next = null;
        return nextHead;
    }

//    1234 4123 3412 2341 1234 4123 3412
//            (4-1)-3%4
//            4-3%4=1
//            4-2%4=2
//            4-6%4=

//    12 21 12
//    2


}
