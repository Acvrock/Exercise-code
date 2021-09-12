package digits;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists2 {

    public static void main(String[] args) {
//        [[1,4,5],[1,3,4],[2,6]]
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));
        ListNode[] list = new ListNode[]{node1, node2, node3};
        ListNode listNode = mergeKLists(list);
        while (listNode != null) {
            System.out.printf(listNode.val + ",");
            listNode = listNode.next;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode(0);
        ListNode p = root;
        while (true) {
            ListNode minNode = null;
            int idx = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                int val = lists[i].val;
                if (minNode == null || minNode.val > val) {
                    minNode = lists[i];
                    idx = i;
                }
            }
            if (idx == -1) {
                break;
            }
            p.next = minNode;
            p = p.next;
            lists[idx] = minNode.next;
        }
        return root.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}