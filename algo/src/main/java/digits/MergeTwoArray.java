package digits;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoArray {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {2, 5, 6};
//        int n = 3;
//        merge(nums1, m, nums2, n);
//        for (int i : nums1) {
//            System.out.printf("," + i);
//        }

//        int[] nums1 = {1 };
//        int m = 1;
//        int[] nums2 = { };
//        int n = 0;
//        merge(nums1, m, nums2, n);
//        for (int i : nums1) {
//            System.out.printf("," + i);
//        }

////        #42
//        int[] nums1 = {0};
//        int m = 0;
//        int[] nums2 = {1};
//        int n = 1;
//        merge(nums1, m, nums2, n);
//        for (int i : nums1) {
//            System.out.printf("," + i);
//        }

//        //        #45
//        int[] nums1 = {2,0};
//        int m = 1;
//        int[] nums2 = {1};
//        int n = 1;
//        merge(nums1, m, nums2, n);
//        for (int i : nums1) {
//            System.out.printf("," + i);
//        }

//        //        #52
//        int[] nums1 = {4, 5, 6, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {1, 2, 3};
//        int n = 3;
//        merge(nums1, m, nums2, n);
//        for (int i : nums1) {
//            System.out.printf("," + i);
//        }

//        //        #9
//        int[] nums1 = {4, 0, 0, 0, 0, 0};
//        int m = 1;
//        int[] nums2 = {1, 2, 3, 5, 6};
//        int n = 5;
//        merge(nums1, m, nums2, n);
//        for (int i : nums1) {
//            System.out.printf("," + i);
//        }


    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0) {
            return;
        }
        int idx2 = n - 1;
        int idx1 = m - 1;
        int nums1idx = (n + m) - 1;
        while (idx2 >= 0) {
            if (idx1 < 0) {
                System.arraycopy(nums2, 0, nums1, 0, idx2 + 1);
                return;
            }
            if (nums1[idx1] > nums2[idx2]) {
                nums1[nums1idx] = nums1[idx1];
                nums1idx--;
                idx1--;
            } else {
                nums1[nums1idx] = nums2[idx2];
                nums1idx--;
                idx2--;
            }
        }
    }
}
